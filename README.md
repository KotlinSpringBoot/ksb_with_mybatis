# ksb_with_mybatis






## 分页 pagehelper


添加依赖

```
compile group: 'com.github.pagehelper', name: 'pagehelper-spring-boot-starter', version: '1.2.3'
```

application.properties

``` 
pagehelper.helper-dialect=mysql
```



```kotlin
override fun listPage(pageNo: Int, size: Int): PageInfo<Article> {
    PageHelper.startPage<Article>(pageNo, size)
    val list = articleMapper.findAll()
    //用PageInfo对结果进行包装
    return PageInfo(list)
}
```


http://127.0.0.1:8002/article/listPage?pageNo=0&size=2


```json

{
  "pageNum": 0,
  "pageSize": 2,
  "size": 2,
  "startRow": 1,
  "endRow": 2,
  "total": 2,
  "pages": 1,
  "list": [
    {
      "id": 1,
      "author": "Jack",
      "gmtCreate": null,
      "gmtModify": null,
      "title": "Spring Boot + Kotlin： 下一代 Java 服务端开发",
      "url": "http://www.jianshu.com/p/3944fde5da90",
      "content": "Kotlin + SpringBoot, Next J2EE Development ..."
    },
    {
      "id": 2,
      "author": "东海陈光剑",
      "gmtCreate": null,
      "gmtModify": null,
      "title": "Spring Boot 2.0 极简教程",
      "url": "http://www.jianshu.com/p/fc24de0c585d",
      "content": "Spring Boot 2.0 极简教程 : 第 I 部分 Spring Boot 框架基础 ..."
    }
  ],
  "prePage": 0,
  "nextPage": 1,
  "isFirstPage": false,
  "isLastPage": false,
  "hasPreviousPage": false,
  "hasNextPage": true,
  "navigatePages": 8,
  "navigatepageNums": [
    1
  ],
  "navigateFirstPage": 1,
  "navigateLastPage": 1,
  "firstPage": 1,
  "lastPage": 1
}
```
