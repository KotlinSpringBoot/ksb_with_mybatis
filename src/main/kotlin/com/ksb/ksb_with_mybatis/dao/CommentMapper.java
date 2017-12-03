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

    @Select("SELECT c.* FROM comment c join article_comments ac on c.id = ac.comment_id WHERE ac.article_id = #{articleId}")
    @ResultMap("BaseResultMap")
    List<Comment> selectByArticleId(Long articleId);
}