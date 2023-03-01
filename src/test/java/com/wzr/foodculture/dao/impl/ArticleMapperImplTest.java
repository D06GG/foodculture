package com.wzr.foodculture.dao.impl;

import com.wzr.foodculture.pojo.Article;
import com.wzr.foodculture.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArticleMapperImplTest {

    @Test
    void selectArticleById() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        Article article = sqlSession.selectOne("selectArticleById",1);
        System.out.print(article.getTitle());
    }
}