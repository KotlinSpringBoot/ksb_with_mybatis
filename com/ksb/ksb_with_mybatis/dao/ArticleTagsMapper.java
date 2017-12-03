package com.ksb.ksb_with_mybatis.dao;

import com.ksb.ksb_with_mybatis.model.ArticleTags;

public interface ArticleTagsMapper {
    int insert(ArticleTags record);

    int insertSelective(ArticleTags record);
}