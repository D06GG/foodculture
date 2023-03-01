package com.wzr.foodculture.dao.impl;

import com.wzr.foodculture.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class CollectMapperImplTest {

    @Test
    void selectCollectByUid() {
        //获取SqlSessionFactory单例
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        //执行查询并将返回结果赋值给aid
        List<Integer> aid = sqlSession.selectList("selectCollectByUid",1);
        System.out.print(aid);
    }
}