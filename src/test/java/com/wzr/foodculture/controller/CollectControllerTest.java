package com.wzr.foodculture.controller;

import com.wzr.foodculture.pojo.Article;
import com.wzr.foodculture.pojo.Collect;
import com.wzr.foodculture.pojo.User;
import com.wzr.foodculture.service.CollectService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class CollectControllerTest {

    @Autowired
    CollectService collectService;

    @Test
    void addCollect() {
        Collect collect = new Collect();
        Integer uid = 1;
        Integer aid = 1;
        collect.setUid(uid);
        collect.setAid(aid);
        int i = collectService.addCollect(collect);
        if(i>0){
            System.out.print("1");
        }else System.out.print("0");
    }

    @Test
    void isCollected() {
        Integer uid = 1;
        Integer aid = 1;
        Integer id = collectService.findId(uid, aid);
        System.out.print(id);
    }

    @Test
    void getCollectsAid(){
        Integer uid = 1;
        List<Article> as = collectService.findArticles(uid);
        System.out.print(as);
    }
}