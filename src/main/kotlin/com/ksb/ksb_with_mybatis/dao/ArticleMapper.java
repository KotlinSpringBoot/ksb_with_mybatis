package com.ksb.ksb_with_mybatis.dao;

import com.ksb.ksb_with_mybatis.model.Article;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);

    @Select("SELECT * FROM article")
    @ResultType(Article.class)
    List<Article> findAll();
}
