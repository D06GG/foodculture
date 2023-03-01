package com.wzr.foodculture.service.impl;

import com.wzr.foodculture.dao.ArticleMapper;
import com.wzr.foodculture.dao.SearchTagMapper;
import com.wzr.foodculture.pojo.Article;
import com.wzr.foodculture.pojo.SearchTag;
import com.wzr.foodculture.service.ArticleService;
import com.wzr.foodculture.service.SearchTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    SearchTagMapper searchTagMapper;

    @Override
    public List<Article> findBest3() {
        return articleMapper.selectArticleByCollectnumDesc();
    }

    @Override
    public List<Article> findTimetoDate3() {
        return articleMapper.selectArticleByTimeDesc();
    }

    @Override
    public int collectAdd1(Integer id) {
        int i = articleMapper.collectNumAdd1(id);
        return i;
    }

    @Override
    public int collectReduce1(Integer id) {
        int i = articleMapper.collectNumReduce1(id);
        return i;
    }

    @Override
    public Integer getArticleNum() {
        Integer i = articleMapper.selectArticleNum();
        return i;
    }

    @Override
    public List<Article> findAll() {
        List<Article> articles = articleMapper.selectAllArticle();
        return articles;
    }

    @Override
    public Article findById(Integer id) {
        Article article = articleMapper.selectArticleById(id);
        return article;
    }

    @Override
    public List<Article> findByAuthor(String author) {
        List<Article> articles = articleMapper.selectArticleByAuthor(author);
        return articles;
    }

    @Override
    public List<Article> findByTitle(String title) {
        List<Article> articles = articleMapper.selectArticleByTitle(title);
        return articles;
    }

    //搜索文章
    @Override
    public List<Article> searchArticle(String text) {
        List<Article> articles = articleMapper.selectArticleByMany(text);
        SearchTag searchTag = searchTagMapper.selectTagByText(text);
        if (searchTag != null){
            searchTagMapper.updateSearchTagAdd1(text);
        }else {
            searchTagMapper.insertSearchTag(text);
        }
        return articles;
    }

    @Override
    public int addArticle(Article article) {
        int i = articleMapper.insertArticle(article);
        return i;
    }

    @Override
    public int updateArticle(Article article) {
        int i = articleMapper.updateArticle(article);
        return i;
    }

    @Override
    public int removeArticle(Integer id) {
        int i = articleMapper.deleteArticle(id);
        return i;
    }
}
