package com.ksb.ksb_with_mybatis.service

import com.github.pagehelper.PageHelper
import com.github.pagehelper.PageInfo
import com.ksb.ksb_with_mybatis.dao.ArticleMapper
import com.ksb.ksb_with_mybatis.model.Article
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class ArticleServiceImpl : ArticleService {
    override fun findAll(): List<Article> {
        return articleMapper.findAll()
    }


    override fun listPage(pageNo: Int, size: Int): PageInfo<Article> {
        PageHelper.startPage<Article>(pageNo, size)
        val list = articleMapper.findAll()
        //用PageInfo对结果进行包装
        return PageInfo(list)
    }

    @Autowired lateinit var articleMapper: ArticleMapper
}
