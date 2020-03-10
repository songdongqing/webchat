package com.example.webchat.mapper;

import com.example.webchat.entity.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Author:   chenfeiliang
 * Description:
 */
@Mapper
public interface ArticleMapper {

    //查询所有
    public List<Article> list();
    //根据ID查记录
    public Article getArticleById(String id);
    //根据ID删除记录
    public boolean deleteArticleById(String id);
    //添加一条记录
    public boolean insertArticle(Article article);
    //根据ID更新一条记录
    public boolean updateArticle(Article article);

}