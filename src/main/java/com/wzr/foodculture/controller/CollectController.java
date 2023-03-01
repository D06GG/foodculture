package com.wzr.foodculture.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzr.foodculture.pojo.Article;
import com.wzr.foodculture.pojo.Collect;
import com.wzr.foodculture.pojo.User;
import com.wzr.foodculture.service.ArticleService;
import com.wzr.foodculture.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class CollectController {

    @Autowired
    CollectService collectService;
    @Autowired
    ArticleService articleService;

    //根据用户ID查询收藏表中的收藏记录
    @RequestMapping("/getCollects")
    public PageInfo<Article> getCollects(HttpSession session){
        //获取当前登录用户并赋值给一个新创建的User对象
        User user =(User) session.getAttribute("usernow");
        //获取当前用户登录的ID
        Integer uid = user.getId();
        //设置PageHelper不分页
        int pageNum = 1;
        int pageSize = 99999;
        //启动pageHelper
        PageHelper.startPage(pageNum,pageSize);
        //执行查询
        List<Article> articles = collectService.findArticles(uid);
        //将查询结果进行封装并返回
        return new PageInfo<Article>(articles);
    }

    //查询是否存在收藏记录，防止重复收藏
    @RequestMapping("/isCollected")
    public boolean isCollected(Integer aid,HttpSession session){
        User user = (User) session.getAttribute("usernow");
        Integer uid = user.getId();
        Integer id =0;
        try{
            id = collectService.findId(uid, aid);
        }catch (Exception e){ }
        if(id>0){
            return true;
        }else return false;
    }

    //新增收藏记录
    @RequestMapping("/addCollect")
    public boolean addCollect(Integer aid,HttpSession session){
        Collect collect = new Collect();
        User user = (User) session.getAttribute("usernow");
        Integer uid = user.getId();
        collect.setUid(uid);
        collect.setAid(aid);
        int i = collectService.addCollect(collect);
        if(i>0){
            int j = articleService.collectAdd1(aid);
            return true;
        }else{
            return false;
        }
    }

    //删除收藏记录
    @RequestMapping("/deleteCollect")
    public ModelAndView deleteCollect(Integer aid, HttpSession session){
        User user = (User) session.getAttribute("usernow");
        Integer uid = user.getId();
        int i = collectService.deleteCollect(uid,aid);
        if(i>0){
            int j = articleService.collectReduce1(aid);
        }
        ModelAndView mv = new ModelAndView("/collect.html");
        return mv;
    }
}
