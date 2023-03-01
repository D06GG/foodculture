package com.wzr.foodculture.service;

import com.wzr.foodculture.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    //获取已订阅用户的邮箱
    public List<String> getEmailBySub();
    //获取用户数量
    public Integer getUserNum();
    //获取订阅数量
    public Integer getSubNum();
    //查找所有用户
    public List<User> findAll();
    //根据ID查找用户
    public User findOneById(Integer id);
    //根据昵称查找用户
    public User findOneByName(String name);
    //根据账户密码查找用户
    public User login(@Param("uname")String uname,@Param("pswd")String pswd);
    //新增用户
    public int regist(User user);
    //更改用户信息
    public int updateUser(User user);
    //删除用户
    public int removeUser(Integer id);
    //订阅
    public int subscribe(User user);
    //取消订阅
    public int nosubscribe(User user);
}
