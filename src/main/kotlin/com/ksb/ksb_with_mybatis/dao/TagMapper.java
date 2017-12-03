package com.ksb.ksb_with_mybatis.dao;

import com.ksb.ksb_with_mybatis.model.Tag;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TagMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Tag record);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);

    @Select("SELECT t.* FROM tag t JOIN article_tags at ON t.id = at.tag_id WHERE at.article_id  = #{articleId}")
    @ResultMap("BaseResultMap")
    List<Tag> selectByArticleId(Long articleId);
}