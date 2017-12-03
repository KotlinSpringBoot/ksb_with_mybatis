package com.ksb.ksb_with_mybatis.dao;

import com.ksb.ksb_with_mybatis.model.Comment;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CommentMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    @Select("SELECT * FROM comment WHERE article_id = #{articleId}")
//    @Results({
//            @Result(id = true, column = "id", property = "id"),
//            @Result(column = "author", property = "author"),
//            @Result(column = "content", property = "content"),
//            @Result(column = "gmt_create", property = "gmtCreate"),
//            @Result(column = "gmt_modify", property = "gmtModify"),
//            @Result(column = "article_id", property = "articleId"),
//            @Result(column = "author", property = "author"),
//    })
    @ResultMap("BaseResultMap")
    List<Comment> selectByArticleId(Long articleId);
}