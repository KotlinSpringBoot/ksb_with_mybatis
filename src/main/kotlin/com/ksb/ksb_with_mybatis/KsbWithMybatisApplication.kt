package com.ksb.ksb_with_mybatis

import com.ksb.ksb_with_mybatis.dao.CommentMapper
import com.ksb.ksb_with_mybatis.dao.TagMapper
import com.ksb.ksb_with_mybatis.model.Article
import com.ksb.ksb_with_mybatis.model.Comment
import com.ksb.ksb_with_mybatis.model.Tag
import com.ksb.ksb_with_mybatis.service.ArticleService
import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.support.beans

@SpringBootApplication
@MapperScan("com.ksb.ksb_with_mybatis.dao")
class KsbWithMybatisApplication

fun main(args: Array<String>) {
    SpringApplicationBuilder().initializers(
            beans {
                bean {
                    ApplicationRunner {
                        val article = Article()
                        article.title = "Kotlin + Spring Boot 服务端开发"
                        article.author = "东海陈光剑"
                        article.content = "下一代 Java 服务端开发"
                        val articleService = ref<ArticleService>()
                        articleService.insert(article)

                        val articleId = article.id

                        val tag1 = Tag()
                        val tag2 = Tag()
                        tag1.articleId = articleId
                        tag1.name = "Kotlin"
                        tag2.articleId = articleId
                        tag2.name = "Spring Boot"
                        val tagMapper = ref<TagMapper>()
                        tagMapper.insert(tag1)
                        tagMapper.insert(tag2)

                        val commentMapper = ref<CommentMapper>()
                        repeat(10) { i ->
                            val comment = Comment()
                            comment.articleId = articleId
                            comment.author = "Jack"
                            comment.content = "评论${i + 1} : KSB 非常好！"
                            commentMapper.insert(comment)
                        }

                    }
                }
            }
    ).sources(KsbWithMybatisApplication::class.java).run(*args)
}
