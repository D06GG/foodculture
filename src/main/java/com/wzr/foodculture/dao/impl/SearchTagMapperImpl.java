package com.wzr.foodculture.dao.impl;

import com.wzr.foodculture.dao.SearchTagMapper;
import com.wzr.foodculture.pojo.SearchTag;
import com.wzr.foodculture.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SearchTagMapperImpl implements SearchTagMapper {
    @Override
    public SearchTag selectTagByText(String text) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        SearchTag searchTag = sqlSession.selectOne("selectTagByText");
        return searchTag;
    }

    @Override
    public int insertSearchTag(String text) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        int i = sqlSession.insert("insertSearchTag",text);
        return i;
    }

    @Override
    public int updateSearchTagAdd1(String text) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        int i = sqlSession.update("updateSearchTagAdd1",text);
        return i;
    }

    @Override
    public List<SearchTag> selectTagByTimesDesc() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        List<SearchTag> searchTags = sqlSession.selectList("selectTagByTimesDesc");
        return searchTags;
    }
}
