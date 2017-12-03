package com.ksb.ksb_with_mybatis.dao;

import com.ksb.ksb_with_mybatis.model.Article;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

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
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "author", property = "author"),
            @Result(column = "gmt_create", property = "gmtCreate"),
            @Result(column = "gmt_modify", property = "gmtModify"),
            @Result(column = "title", property = "title"),
            @Result(column = "id",
                    property = "comments",
                    many = @Many(
                            select = "com.ksb.ksb_with_mybatis.dao.CommentMapper.selectByArticleId",
                            fetchType = FetchType.EAGER
                    )
            ),
            @Result(column = "id",
                    property = "tags",
                    many = @Many(
                            select = "com.ksb.ksb_with_mybatis.dao.TagMapper.selectByArticleId",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<Article> findAll();
}
