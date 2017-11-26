package com.ksb.ksb_with_mybatis.controller

import com.ksb.ksb_with_mybatis.dao.ArticleMapper
import com.ksb.ksb_with_mybatis.model.Article
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/article")
class ArticleController {

    @Autowired lateinit var articleMapper: ArticleMapper

    @GetMapping(value = *arrayOf("", "/"))
    fun listAll(): List<Article> {
        return articleMapper.findAll()
    }

}
