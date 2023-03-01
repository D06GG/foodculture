package com.wzr.foodculture.service.impl;

import com.wzr.foodculture.dao.ArticleMapper;
import com.wzr.foodculture.dao.impl.ArticleMapperImpl;
import com.wzr.foodculture.pojo.Article;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ArticleServiceImplTest {

    ArticleMapper articleMapper = new ArticleMapperImpl();

    @Test
    void findAll() {
        List<Article> articles = articleMapper.selectAllArticle();
        for(int i = 0 ; i<articles.size();i++){
            Article a = articles.get(i);
            System.out.print(a.getId()+" ");
            System.out.print(a.getTitle()+" ");
            System.out.print(a.getInfo()+" ");
            System.out.print(a.getAuthor()+" ");
            System.out.print(a.getLocal()+" ");
            System.out.print(a.getCover()+" ");
            System.out.print(a.getTime()+" ");
            System.out.println(a.getCollectnum());
        }
    }
}