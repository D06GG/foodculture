package com.wzr.foodculture.dao.impl;

import com.wzr.foodculture.dao.ArticleMapper;
import com.wzr.foodculture.pojo.Article;
import com.wzr.foodculture.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleMapperImpl implements ArticleMapper {
    @Override
    public List<Article> selectArticleByCollectnumDesc() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        return sqlSession.selectList("selectArticleByCollectnumDesc");
    }

    @Override
    public List<Article> selectArticleByTimeDesc() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        return sqlSession.selectList("selectArticleByTimeDesc");
    }

    @Override
    public int collectNumAdd1(Integer integer) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        int i = sqlSession.update("collectNumAdd1",integer);
        return i;
    }

    @Override
    public int collectNumReduce1(Integer integer) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        int i = sqlSession.update("collectNumReduce1",integer);
        return i;
    }

    @Override
    public Article uptodateArticle() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        return sqlSession.selectOne("uptodateArticle");
    }

    @Override
    public Integer selectArticleNum() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        Integer anum = sqlSession.selectOne("selectArticleNum");
        return anum;
    }

    @Override
    public List<Article> selectAllArticle() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        List<Article> articles = sqlSession.selectList("selectAllArticle");
        return articles;
    }

    @Override
    public List<Article> selectArticleByAuthor(String author) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        List<Article> articles = sqlSession.selectList("selectArticleByAuthor",author);
        return articles;
    }

    @Override
    public Article selectArticleById(Integer id) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        Article article = sqlSession.selectOne("selectArticleById",id);
        return article;
    }

    @Override
    public List<Article> selectArticleByTitle(String title) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        List<Article> articles = sqlSession.selectList("selectArticleByTitle",title);
        return articles;
    }

    @Override
    public List<Article> selectArticleByMany(String text) {
        //搜索功能
        //获取SqlSessionFactory单例
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //执行查询操作并赋值给articles
        List<Article> articles = sqlSession.selectList("selectArticleByMany",text);
        //返回查询结果
        return articles;
    }

    @Override
    public int insertArticle(Article article) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        int i = sqlSession.insert("insertArticle",article);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }

    @Override
    public int updateArticle(Article article) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        int i = sqlSession.update("updateArticle",article);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }

    @Override
    public int deleteArticle(Integer id) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        int i = sqlSession.insert("deleteArticle",id);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }
}
