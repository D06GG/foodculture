package com.wzr.foodculture.controller;

import com.wzr.foodculture.pojo.User;
import com.wzr.foodculture.service.UserService;
import com.wzr.foodculture.utils.Md5Utils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserControllerTest {

    @Autowired
    UserService userService;

    @Test
    void regist() {
        User user = new User();
        user.setUsername("xianhe");
        user.setPassword("123");
        user.setName("咸赫");
        user.setPower(0);
        user.setEmail("1780816534@qq.com");
        user.setSubscribe(0);
        //实体化MD5加密工具类
        Md5Utils md5Utils = new Md5Utils();
        //将封装的即将完成注册的user对象的密码进行MD5加密
        user.setPassword(md5Utils.md5(user.getPassword()));

        int i = userService.regist(user);
        if(i>0){
            System.out.println("111111");
        }else {
            System.out.println("000000");
        }
    }

    @Test
    public void updateUser2(){
        User user = new User();
        user.setId(4);
        user.setUsername("xianhe");
        user.setPassword("202cb962ac59075b964b07152d234b70");
        user.setName("咸赫");
        user.setEmail("1780816534@qq.com");
        user.setSubscribe(1);
        user.setPower(0);
        int i = userService.updateUser(user);
        if(i>0){
            System.out.println("yesyesyesyesyes");
        }else {
            System.out.println("nonononono");
        }
    }
}