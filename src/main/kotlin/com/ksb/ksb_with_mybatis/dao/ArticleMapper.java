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
            @Result(column = "id", property = "comments",
                    many = @Many(select = "com.ksb.ksb_with_mybatis.dao.CommentMapper.selectByArticleId", fetchType = FetchType.EAGER)),
            @Result(column = "id", property = "tags",
                    many = @Many(select = "com.ksb.ksb_with_mybatis.dao.TagMapper.selectByArticleId", fetchType = FetchType.EAGER))
    })
    List<Article> findAll();
}

/**
 * EAGER，那么表示取出这条数据时，它关联的数据也同时取出放入内存中
 * LAZY， 那么取出这条数据时，它关联的数据并不取出来，在同一个session中，什么时候要用，就什么时候取(再次访问数据库)。
 * Mybatis的延迟加载是针对嵌套查询而言的，
 * 是指在进行查询的时候先只查询最外层的SQL，
 * 对于内层SQL将在需要使用的时候才查询出来。
 * Mybatis的延迟加载默认是关闭的，即默认是一次就将所有的嵌套SQL一并查了将对象所有的信息都查询出来。
 **/