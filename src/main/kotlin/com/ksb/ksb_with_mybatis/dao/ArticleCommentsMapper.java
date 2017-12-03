package com.ksb.ksb_with_mybatis.dao;

import com.ksb.ksb_with_mybatis.model.ArticleComments;

public interface ArticleCommentsMapper {
    int insert(ArticleComments record);

    int insertSelective(ArticleComments record);
}