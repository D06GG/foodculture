package com.wzr.foodculture.dao;

import com.wzr.foodculture.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserMapper {
    //获取已订阅用户的邮箱
    public List<String> selectEmailBySub();
    //获取用户数量
    public Integer selectUserNum();
    //获取订阅数量
    public Integer selectSubNum();
    //查找所有用户
    public List<User> selectAllUser();
    //根据ID查找用户
    public User selectUserById(Integer id);
    //根据账户密码查找用户
    public User selectUserByUnameAndPswd(@Param("uname")String uname,@Param("pswd")String pswd);
    //根据昵称查找用户
    public User selectUserByName(String name);
    //新增用户
    public int insertUser(User user);
    //订阅
    public int subscribe(User user);
    //取消订阅
    public int nosubscribe(User user);
    //更改用户信息
    public int updateUser(User user);
    //删除用户
    public int deleteUser(Integer id);
}
