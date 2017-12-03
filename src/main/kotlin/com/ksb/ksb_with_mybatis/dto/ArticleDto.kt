package com.ksb.ksb_with_mybatis.dto

import com.ksb.ksb_with_mybatis.model.Article
import com.ksb.ksb_with_mybatis.model.Comment
import com.ksb.ksb_with_mybatis.model.Tag

class ArticleDto : Article() {
    lateinit var tags: Set<Tag>
    lateinit var comments: Set<Comment>
}