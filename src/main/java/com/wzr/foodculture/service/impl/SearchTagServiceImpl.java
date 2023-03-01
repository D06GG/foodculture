package com.wzr.foodculture.service.impl;

import com.wzr.foodculture.dao.SearchTagMapper;
import com.wzr.foodculture.pojo.SearchTag;
import com.wzr.foodculture.service.SearchTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchTagServiceImpl implements SearchTagService {

    @Autowired
    SearchTagMapper searchTagMapper;

    @Override
    public SearchTag findByText(String text) {
        return searchTagMapper.selectTagByText(text);
    }

    @Override
    public int newTag(String text) {
        int i = searchTagMapper.insertSearchTag(text);
        return i;
    }

    @Override
    public int timesAdd1(String text) {
        int i = searchTagMapper.updateSearchTagAdd1(text);
        return i;
    }

    @Override
    public List<SearchTag> findTagByTimesDesc() {
        return searchTagMapper.selectTagByTimesDesc();
    }
}
