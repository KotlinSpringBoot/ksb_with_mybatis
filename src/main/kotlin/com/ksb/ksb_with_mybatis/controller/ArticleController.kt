package com.ksb.ksb_with_mybatis.controller

import com.github.pagehelper.PageInfo
import com.ksb.ksb_with_mybatis.model.Article
import com.ksb.ksb_with_mybatis.service.ArticleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/article")
class ArticleController {

    @Autowired lateinit var articleService: ArticleService

    @GetMapping(value = *arrayOf("", "/"))
    fun listAll(): List<Article> {
        return articleService.findAll()
    }

    @GetMapping(value = "/listPage")
    fun listPage(@RequestParam("pageNo") pageNo: Int, @RequestParam("size") size: Int): PageInfo<Article> {
        return articleService.listPage(pageNo, size)
    }

}
