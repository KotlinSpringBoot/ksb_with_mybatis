package com.ksb.ksb_with_mybatis.controller

import com.github.pagehelper.PageInfo
import com.ksb.ksb_with_mybatis.dao.CommentMapper
import com.ksb.ksb_with_mybatis.dao.TagMapper
import com.ksb.ksb_with_mybatis.model.Article
import com.ksb.ksb_with_mybatis.model.Comment
import com.ksb.ksb_with_mybatis.model.Tag
import com.ksb.ksb_with_mybatis.service.ArticleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/article")
class ArticleController {

    @Autowired lateinit var articleService: ArticleService

    @GetMapping(value = *arrayOf("", "/"))
    fun listAll(): List<Article> {
        return articleService.findAll()
    }

    @GetMapping(value = "/page")
    fun listPage(@RequestParam(value = "pageNo", defaultValue = "0") pageNo: Int,
                 @RequestParam(value = "size", defaultValue = "10") size: Int): PageInfo<Article> {
        return articleService.listPage(pageNo, size)
    }


    @Autowired lateinit var commentMapper: CommentMapper
    @GetMapping("/{articleId}/comments")
    fun selectCommentsByArticleId(@PathVariable("articleId") articleId: Long): List<Comment> {
        return commentMapper.selectByArticleId(articleId)
    }


    @Autowired lateinit var tagMapper: TagMapper
    @GetMapping("/{articleId}/tags")
    fun selectTagsByArticleId(@PathVariable("articleId") articleId: Long): List<Tag> {
        return tagMapper.selectByArticleId(articleId)
    }

}
