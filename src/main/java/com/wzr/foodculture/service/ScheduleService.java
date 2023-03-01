package com.wzr.foodculture.service;

import com.wzr.foodculture.dao.ArticleMapper;
import com.wzr.foodculture.dao.UserMapper;
import com.wzr.foodculture.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class ScheduleService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    MailService mailService;

    //使用Scheduled创建一个定时任务，并使用cron表达式定时
    //该处cron表达式意为每周五晚上19：00
    @Scheduled(cron = "* * 17 * * 5")
    public void scheduled(){
        //获取已订阅的用户的邮箱
        List<String> emails = userMapper.selectEmailBySub();
        //获取最新的文章
        Article article = articleMapper.uptodateArticle();
        //将文章链接赋值给正文
        String content= article.getLocal();
        //给标题赋值
        String title="食录网最新的文章，想知道本周都有哪些新鲜知识吗！";
        //利用循环，将邮件发送至每一个已订阅用户的邮箱
        for(int i =0 ;i<emails.size();i++){
            mailService.sendHtmlMail(emails.get(i),title,content);
        }
    }
}
