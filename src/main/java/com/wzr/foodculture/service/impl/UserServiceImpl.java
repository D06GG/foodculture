package com.wzr.foodculture.service.impl;

import com.wzr.foodculture.dao.UserMapper;
import com.wzr.foodculture.pojo.User;
import com.wzr.foodculture.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<String> getEmailBySub() {
        return userMapper.selectEmailBySub();
    }

    @Override
    public Integer getUserNum() {
        Integer i = userMapper.selectUserNum();
        return i;
    }

    @Override
    public Integer getSubNum() {
        Integer i = userMapper.selectSubNum();
        return i;
    }

    @Override
    public List<User> findAll() {
        List<User> users = userMapper.selectAllUser();
        return users;
    }

    @Override
    public User findOneById(Integer id) {
        User user = userMapper.selectUserById(id);
        return user;
    }

    @Override
    public User findOneByName(String name) {
        User user = userMapper.selectUserByName(name);
        return user;
    }

    @Override
    public User login(String uname, String pswd) {
        User user = userMapper.selectUserByUnameAndPswd(uname,pswd);
        return user;
    }

    @Override
    public int regist(User user) {
        int i = userMapper.insertUser(user);
        return i;
    }

    @Override
    public int updateUser(User user) {
        int i = userMapper.updateUser(user);
        return i;
    }

    @Override
    public int removeUser(Integer id) {
        int i = userMapper.deleteUser(id);
        return i;
    }

    @Override
    public int subscribe(User user) {
        int i = userMapper.subscribe(user);
        return i;
    }

    @Override
    public int nosubscribe(User user) {
        int i = userMapper.nosubscribe(user);
        return i;
    }

}
