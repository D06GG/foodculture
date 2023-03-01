package com.wzr.foodculture.controller;

import com.github.pagehelper.PageHelper;
import com.wzr.foodculture.pojo.Article;
import com.wzr.foodculture.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ArticleControllerTest {

    @Autowired
    ArticleService articleService;

    @Test
    void searchArticles() {
        String text = "怪盗基德";
        int pageNum = 1;
        int pageSize = 4;
        PageHelper.startPage(pageNum,pageSize);
        List<Article> articles = articleService.searchArticle(text);
        System.out.print(articles.get(0).getTitle());
    }
}