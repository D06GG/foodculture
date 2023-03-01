package com.wzr.foodculture.dao;

import com.wzr.foodculture.pojo.SearchTag;

import java.util.List;

public interface SearchTagMapper {
    //查询数据库中是否存在该关键词
    public SearchTag selectTagByText(String text);
    //新增新关键词
    public int insertSearchTag(String text);
    //关键词搜索数+1
    public int updateSearchTagAdd1(String text);
    //根据搜索数降序查询
    public List<SearchTag> selectTagByTimesDesc();
}
