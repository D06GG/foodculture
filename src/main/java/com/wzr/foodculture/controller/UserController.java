package com.wzr.foodculture.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzr.foodculture.pojo.User;
import com.wzr.foodculture.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.wzr.foodculture.utils.Md5Utils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("index.html");
        return mv;
    }

    //获取用户数量
    @RequestMapping("/getUserNum")
    public Integer getArticleNum(){
        int i = userService.getUserNum();
        return i;
    }

    //获取订阅数量
    @RequestMapping("/getSubNum")
    public Integer getSubNum(){
        int i = userService.getSubNum();
        return i;
    }

    //根据ID获取用户
    @RequestMapping("/getUserById")
    public User getUserById(Integer id){
        User user = userService.findOneById(id);
        return user;
    }

    //登录普通用户
    @RequestMapping("/login")
    public boolean login(String uname, String pswd, HttpSession session){
        //实体化MD5加密工具类
        Md5Utils md5Utils = new Md5Utils();
        //将用户提交的密码进行MD5码加密
        String  pswdMd5 = md5Utils.md5(pswd);
        //执行Service层的登录方法
        User user = userService.login(uname,pswdMd5);
        //如果查询到用户
        if(null !=user){
            //将用户信息存入到session会话中
            session.setAttribute("usernow",user);
            return true;
        }else {
            return false;
        }
    }

    //登录管理员用户
    @RequestMapping("/login2")
    public boolean login2(String uname, String pswd, HttpSession session){
        Md5Utils md5Utils = new Md5Utils();
        String  pswdMd5 = md5Utils.md5(pswd);
        User user = userService.login(uname,pswdMd5);
        if(null !=user && user.getPower()==1){
            session.setAttribute("usernow",user);
            return true;
        }else {
            return false;
        }
    }

    //注册用户
    @RequestMapping("/addUser")
    public Boolean regist(User user){
        //实体化MD5加密工具类
        Md5Utils md5Utils = new Md5Utils();
        //将封装的即将完成注册的user对象的密码进行MD5加密
        user.setPassword(md5Utils.md5(user.getPassword()));
        //执行Service层的注册方法并获取返回值，执行失败则会返回0
        int i = userService.regist(user);
        return i>0;
    }

    //获取当前登录用户
    @RequestMapping("/getUser")
    public User getUser(HttpSession session){
        //从session中获取当前登录用户并强制转换为User对象，赋值给user
        User user =(User) session.getAttribute("usernow");
        //返回user
        return user;
    }

    //获取登录状态（是否登录）
    @RequestMapping("/isLogin")
    public boolean isLogin(HttpSession session){
        if(session.getAttribute("usernow") != null){
            return true;
        }else return false;
    }

    //管理员获取数据库中所有用户
    @RequestMapping("/getAllUser")
    public PageInfo<User> getAllUser(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        //通过userService的findAll方法查询数据库中的所有用户
        List<User> users = userService.findAll();
        //返回查询结果
        return new PageInfo<User>(users);
    }
    //管理员删除用户
    @RequestMapping("/deleteUser")
    public ModelAndView deleteDoctor(int id){
        //定义视图
        ModelAndView mv = new ModelAndView("/usermanage.html");
        //通过userService的removeUser方法执行删除操作
        int i = userService.removeUser(id);
        //返回视图，起到删除用户后刷新页面即时将删除结果显示在页面上的作用
        return mv;
    }
    //判断用户订阅状态
    @RequestMapping("/isSubscribe")
    public boolean isSubscribe(HttpSession session){
        User user = (User) session.getAttribute("usernow");
        Integer sub = user.getSubscribe();
        if(sub == 0){
            return false;
        }else {
            return true;
        }
    }

    //用户订阅
    @RequestMapping("/subscribe")
    public boolean subscribe(HttpSession session){
        User user =(User) session.getAttribute("usernow");
        int i = userService.subscribe(user);
        if(i>0){
            user.setSubscribe(1);
            session.setAttribute("usernow",user);
            return true;
        }else {
            return false;
        }
    }
    //取消订阅
    @RequestMapping("/nosubscribe")
    public boolean nosubscribe(HttpSession session){
        User user =(User) session.getAttribute("usernow");
        int i = userService.nosubscribe(user);
        if(i>0){
            user.setSubscribe(0);
            session.setAttribute("usernow",user);
            return true;
        }else {
            return false;
        }
    }
    //管理员修改用户信息
    @RequestMapping("/updateUser1")
    public ModelAndView updateUser1(Integer id, HttpServletRequest request){
        User user = userService.findOneById(id);
        request.setAttribute("userNeedUpdate",user);
        ModelAndView mv = new ModelAndView("/useralter.html");
        return mv;
    }
    @RequestMapping("/updateUser2")
    public boolean updateUser2(User user){
        int i = userService.updateUser(user);
        if(i>0){
            return true;
        }else {
            return false;
        }
    }
}
