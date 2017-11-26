package com.ksb.ksb_with_mybatis.service

import com.github.pagehelper.PageInfo
import com.ksb.ksb_with_mybatis.model.Article

interface ArticleService {

    fun findAll():List<Article>

    fun listPage(pageNo: Int, size: Int): PageInfo<Article>
}
