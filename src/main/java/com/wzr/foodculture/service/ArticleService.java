package com.wzr.foodculture.service;

import com.wzr.foodculture.pojo.Article;

import java.util.List;

public interface ArticleService {
    //查询收藏数前三的文章
    public List<Article> findBest3();
    //查询最新的三篇文章
    public List<Article> findTimetoDate3();
    //收藏数+-1
    public int collectAdd1(Integer id);
    public int collectReduce1(Integer id);
    //文章总数
    public Integer getArticleNum();
    //查找所有文章
    public List<Article> findAll();
    //根据Id查找文章
    public Article findById(Integer id);
    //根据作者查找文章
    public List<Article> findByAuthor(String author);
    //根据标题查找文章
    public List<Article> findByTitle(String title);
    //实现搜索功能的查找文章
    public List<Article> searchArticle(String text);
    //新增文章
    public int addArticle(Article article);
    //更改文章信息
    public int updateArticle(Article article);
    //删除文章
    public int removeArticle(Integer id);
}
