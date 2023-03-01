package com.wzr.foodculture.dao.impl;

import com.wzr.foodculture.dao.CollectMapper;
import com.wzr.foodculture.pojo.Collect;
import com.wzr.foodculture.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CollectMapperImpl implements CollectMapper {

    @Override
    public List<Integer> selectCollectByUid(Integer uid) {
        //获取SqlSessionFactory单例
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //执行查询并将返回结果赋值给aid
        List<Integer> aid = sqlSession.selectList("selectCollectByUid",uid);
        //返回查询结果
        return aid;
    }

    @Override
    public Integer selectCollectByUidAndAid(Integer uid, Integer aid) {
        Map<String,Object> param=new HashMap<>();
        param.put("uid",uid);
        param.put("aid",aid);
        //获取SqlSessionFactory单例
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        Integer id = sqlSession.selectOne("selectCollectByUidAndAid",param);
        //返回查询结果
        return id;
    }

    @Override
    public int insertCollect(Collect collect) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        int i = sqlSession.insert("insertCollect",collect);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }

    @Override
    public int deleteCollect(Integer uid,Integer aid) {
        Map<String,Object> param=new HashMap<>();
        param.put("uid",uid);
        param.put("aid",aid);

        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        int i = sqlSession.delete("deleteCollect",param);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }
}
