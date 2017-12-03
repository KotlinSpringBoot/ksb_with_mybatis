package com.ksb.ksb_with_mybatis.service

import com.github.pagehelper.PageHelper
import com.github.pagehelper.PageInfo
import com.ksb.ksb_with_mybatis.dao.ArticleMapper
import com.ksb.ksb_with_mybatis.model.Article
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class ArticleServiceImpl : ArticleService {
    override fun insert(article: Article): Int {
        return articleMapper.insert(article)
    }

    override fun findAll(): List<Article> {
        return articleMapper.findAll()
    }


    override fun listPage(pageNo: Int, size: Int): PageInfo<Article> {
        PageHelper.startPage<Article>(pageNo, size)
        // 一开始看到这段代码时候，会觉得应该是内存分页。
        // 其实插件对 mybatis 执行流程进行了增强，添加了 limit 以及 count 查询，属于物理分页
        val list = articleMapper.findAll()
        //用PageInfo对结果进行包装
        return PageInfo(list)
    }

    @Autowired lateinit var articleMapper: ArticleMapper
}


/**
 *

什么时候会导致不安全的分页？

PageHelper 方法使用了静态的 ThreadLocal 参数，分页参数和线程是绑定的。

只要你可以保证在 PageHelper 方法调用后紧跟 MyBatis 查询方法，这就是安全的。因为 PageHelper 在 finally 代码段中自动清除了 ThreadLocal 存储的对象。

如果代码在进入 Executor 前发生异常，就会导致线程不可用，这属于人为的 Bug（例如接口方法和 XML 中的不匹配，导致找不到 MappedStatement 时）， 这种情况由于线程不可用，也不会导致 ThreadLocal 参数被错误的使用。

但是如果你写出下面这样的代码，就是不安全的用法：

PageHelper.startPage(1, 10);
List<Country> list;
if(param1 != null){
list = countryMapper.selectIf(param1);
} else {
list = new ArrayList<Country>();
}
这种情况下由于 param1 存在 null 的情况，就会导致 PageHelper 生产了一个分页参数，但是没有被消费，这个参数就会一直保留在这个线程上。当这个线程再次被使用时，就可能导致不该分页的方法去消费这个分页参数，这就产生了莫名其妙的分页。

上面这个代码，应该写成下面这个样子：

List<Country> list;
if(param1 != null){
PageHelper.startPage(1, 10);
list = countryMapper.selectIf(param1);
} else {
list = new ArrayList<Country>();
}
这种写法就能保证安全。

如果你对此不放心，你可以手动清理 ThreadLocal 存储的分页参数，可以像下面这样使用：

List<Country> list;
if(param1 != null){
PageHelper.startPage(1, 10);
try{
list = countryMapper.selectAll();
} finally {
PageHelper.clearPage();
}
} else {
list = new ArrayList<Country>();
}
这么写很不好看，而且没有必要。

 * */