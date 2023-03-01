package com.wzr.foodculture.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzr.foodculture.pojo.Article;
import com.wzr.foodculture.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;

    //获取推荐文章*3
    @RequestMapping("/getHot3")
    public PageInfo<Article> getHot3(){
        PageHelper.startPage(1,3);
        List<Article> articles = articleService.findBest3();
        return new PageInfo<Article>(articles);
    }

    //获取最新文章*3
    @RequestMapping("/getNew3")
    public PageInfo<Article> getNew3(){
        PageHelper.startPage(1,3);
        List<Article> articles = articleService.findTimetoDate3();
        return new PageInfo<Article>(articles);
    }

    //获取文章总数
    @RequestMapping("/getArticleNum")
    public Integer getArticleNum(){
        int i = articleService.getArticleNum();
        return i;
    }
    //根据ID获取文章
    @RequestMapping("/getArticleById")
    public Article getArticleById(Integer id){
        Article article = articleService.findById(id);
        return article;
    }
    //管理员添加文章
    @RequestMapping("/addArticle")
    public boolean addArticle(Article article){
        article.setCover("/upload/cover_0.jpg");
        article.setLocal("/articles/0.html");
        //执行Service层的添加文章的方法并获取返回值
        int i =  articleService.addArticle(article);
        //若添加失败会返回0
        return i>0;
    }
    //管理员获取所有文章
    @RequestMapping("/getAllArticles")
    public PageInfo<Article> getAllArticles(int pageNum,int pageSize){
        //启动pageHelper
        PageHelper.startPage(pageNum,pageSize);
        //执行查询
        List<Article> articles = articleService.findAll();
        //返回结果
        return new PageInfo<Article>(articles);
    }
    //主页显示以及搜索文章
    @RequestMapping("/searchArticles")
    public PageInfo<Article> searchArticles(String text,int pageNum,int pageSize){
        //启动pageHelper
        PageHelper.startPage(pageNum,pageSize);
        //执行查询
        List<Article> articles = articleService.searchArticle(text);
        //返回结果
        return new PageInfo<Article>(articles);
    }

    //管理员修改文章信息
    @RequestMapping("/updateArticle1")
    public ModelAndView updateUser1(Integer id, HttpServletRequest request){
        Article article = articleService.findById(id);
        request.setAttribute("articleNeedUpdate",article);
        ModelAndView mv = new ModelAndView("/articlealter.html");
        return mv;
    }
    @RequestMapping("/updateArticle2")
    public boolean updateArticle2(Article article){
        int i = articleService.updateArticle(article);
        if(i>0){
            return true;
        }else {
            return false;
        }
    }

    //管理员删除用户
    @RequestMapping("/deleteArticle")
    public ModelAndView deleteDoctor(int id){
        //定义视图
        ModelAndView mv = new ModelAndView("/articlemanage.html");
        //通过userService的removeUser方法执行删除操作
        int i = articleService.removeArticle(id);
        //返回视图，起到删除用户后刷新页面即时将删除结果显示在页面上的作用
        return mv;
    }
}
