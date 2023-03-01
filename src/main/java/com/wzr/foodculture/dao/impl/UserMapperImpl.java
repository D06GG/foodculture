package com.wzr.foodculture.dao.impl;

import com.wzr.foodculture.dao.UserMapper;
import com.wzr.foodculture.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.wzr.foodculture.utils.SqlSessionFactoryUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserMapperImpl implements UserMapper {


    @Override
    public List<String> selectEmailBySub() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        List<String> emails = sqlSession.selectList("selectEmailBySub");
        return emails;
    }

    @Override
    public Integer selectUserNum() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        Integer i = sqlSession.selectOne("selectUserNum");
        return i;
    }

    @Override
    public Integer selectSubNum() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        Integer i = sqlSession.selectOne("selectSubNum");
        return i;
    }

    @Override
    public List<User> selectAllUser() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        List<User> users = sqlSession.selectList("selectAllUser");
        return users;
    }

    @Override
    public User selectUserById(Integer id) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        User u = sqlSession.selectOne("selectUserById",id);
        return u;
    }

    @Override
    public User selectUserByUnameAndPswd(String uname, String pswd) {
        Map<String,Object> param=new HashMap<>();
        param.put("uname",uname);
        param.put("pswd",pswd);
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        User u = sqlSession.selectOne("selectUserByUnameAndPswd",param);
        return u;
    }

    @Override
    public User selectUserByName(String name) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        User u = sqlSession.selectOne("selectUserByName",name);
        return u;
    }

    @Override
    public int insertUser(User user) {
        //生成SqlSessionFactory单例
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //调用insert方法，执行%Mapper.xml中的sql语句
        int i = sqlSession.insert("insertUser",user);
        //提交事务
        sqlSession.commit();
        //关闭sqlSession
        sqlSession.close();
        return i;
    }

    @Override
    public int subscribe(User user) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        int i = sqlSession.update("subscribe",user);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }

    @Override
    public int nosubscribe(User user) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        int i = sqlSession.update("nosubscribe",user);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }

    @Override
    public int updateUser(User user) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        int i = sqlSession.update("updateUser",user);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }

    @Override
    public int deleteUser(Integer id) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        int i = sqlSession.insert("deleteUser",id);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }
}
