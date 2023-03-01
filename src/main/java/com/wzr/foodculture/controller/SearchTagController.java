package com.wzr.foodculture.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzr.foodculture.dao.SearchTagMapper;
import com.wzr.foodculture.pojo.SearchTag;
import com.wzr.foodculture.service.SearchTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchTagController {

    @Autowired
    SearchTagService searchTagService;

    //获取热门搜索关键词
    @RequestMapping("/getTagsHot")
    public PageInfo<SearchTag> getTagsHot(){
        PageHelper.startPage(1,7);
        List<SearchTag> articles = searchTagService.findTagByTimesDesc();
        return new PageInfo<SearchTag>(articles);
    }

    //查询是否存在该关键词
    @RequestMapping("/getTag")
    public SearchTag getTag(String text){
        return searchTagService.findByText(text);
    }


}
