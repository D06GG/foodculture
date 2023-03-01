package com.wzr.foodculture.service.impl;

import com.wzr.foodculture.service.MailService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class MailServiceImplTest {

    @Autowired
    private MailService mailService;

    @Test
    void sendHtmlMail() {
        String userEmail = "1780816534@qq.com";
        String title="食录网最热门的文章，想知道本周都有哪些新鲜知识吗！";
        String content="测试测试测试";
        mailService.sendHtmlMail(userEmail,title,content);
    }

    @Test
    void sendMail() {
        String userEmail = "982897333@qq.com";
        String title="食录网最热门的文章，想知道本周都有哪些新鲜知识吗！";
        String content="111.164.172.63:8099/index2.html";
        mailService.sendSimpleMail(userEmail,title,content);
    }
}