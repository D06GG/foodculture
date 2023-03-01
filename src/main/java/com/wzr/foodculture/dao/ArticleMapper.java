package com.wzr.foodculture.dao;

import com.wzr.foodculture.pojo.Article;

import java.util.List;

public interface ArticleMapper {
    //查询收藏数前三的文章
    public List<Article> selectArticleByCollectnumDesc();
    //查询最新的三篇文章
    public List<Article> selectArticleByTimeDesc();
    //文章收藏数加减一
    public int collectNumAdd1(Integer integer);
    public int collectNumReduce1(Integer integer);
    //查询最新文章
    public Article uptodateArticle();
    //查询目前文章总是
    public Integer selectArticleNum();
    //查询所有文章
    public List<Article> selectAllArticle();
    //根据作者查询文章
    public List<Article> selectArticleByAuthor(String author);
    //根据ID查询文章
    public Article selectArticleById(Integer id);
    //根据题目查询文章
    public List<Article> selectArticleByTitle(String title);
    //根据很多查询文章（搜索功能）
    public List<Article> selectArticleByMany(String text);
    //新增文章
    public int insertArticle(Article article);
    //更改文章信息
    public int updateArticle(Article article);
    //删除文章
    public int deleteArticle(Integer id);
}
