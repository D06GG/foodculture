package com.wzr.foodculture.service.impl;

import com.wzr.foodculture.dao.ArticleMapper;
import com.wzr.foodculture.dao.CollectMapper;
import com.wzr.foodculture.pojo.Article;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class CollectServiceImplTest {

    @Autowired
    CollectMapper collectMapper;
    @Autowired
    ArticleMapper articleMapper;

    @Test
    void findArticles() {
        //假设当前用户ID为1
        Integer uid = 1;
        //查询获得用户已经收藏的文章ID
        List<Integer> aids = new ArrayList<>();
        aids = collectMapper.selectCollectByUid(uid);
        System.out.println(aids);
        //创建一个ArrticleList，存放文章对象
        List<Article> articles = new ArrayList<>();
        //如果查询结果不为空
        if(aids.size()>0){
            //对每一个查询结果
            for(int i = 0 ; i < aids.size();i++){
                //获取第i个文章ID
                Integer aid = aids.get(i);
                //根据第i个文章ID查询文章并赋值给art
                Article art = articleMapper.selectArticleById(aid);
                //将查询到的文章存放到articles列表中
                articles.add(art);
            }
            System.out.print(articles);
        }else {
            System.out.print("未查询到");
        }
    }
}