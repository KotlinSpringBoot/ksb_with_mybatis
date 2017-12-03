package com.ksb.ksb_with_mybatis

import com.ksb.ksb_with_mybatis.dao.ArticleCommentsMapper
import com.ksb.ksb_with_mybatis.dao.ArticleTagsMapper
import com.ksb.ksb_with_mybatis.dao.CommentMapper
import com.ksb.ksb_with_mybatis.dao.TagMapper
import com.ksb.ksb_with_mybatis.model.*
import com.ksb.ksb_with_mybatis.service.ArticleService
import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.support.beans

@SpringBootApplication
@MapperScan(basePackages = arrayOf("com.ksb.ksb_with_mybatis.dao")) // 这行需要配置 Mapper 接口的扫描
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

                        val tag1 = Tag()
                        val tag2 = Tag()
                        tag1.name = "Kotlin"
                        tag2.name = "Spring Boot"
                        val tagMapper = ref<TagMapper>()
                        tagMapper.insert(tag1)
                        tagMapper.insert(tag2)

                        val articleId = article.id
                        val articleTagsMapper = ref<ArticleTagsMapper>()
                        val articleTags1 = ArticleTags()
                        articleTags1.articleId = articleId
                        articleTags1.tagId = tag1.id
                        articleTagsMapper.insert(articleTags1)

                        val articleTags2 = ArticleTags()
                        articleTags2.tagId = tag2.id
                        articleTags2.articleId = articleId
                        articleTagsMapper.insert(articleTags2)

                        val commentMapper = ref<CommentMapper>()
                        val articleCommentsMapper = ref<ArticleCommentsMapper>()
                        repeat(10) { i ->
                            val comment = Comment()
                            comment.author = "Jack"
                            comment.content = "评论${i + 1} : KSB 非常好！"
                            commentMapper.insert(comment)

                            val articleComments = ArticleComments()
                            articleComments.articleId = articleId
                            articleComments.commentId = comment.id
                            articleCommentsMapper.insert(articleComments)

                        }

                    }
                }
            }
    ).sources(KsbWithMybatisApplication::class.java).run(*args)
}
