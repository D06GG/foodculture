package com.wzr.foodculture.service;

import com.wzr.foodculture.pojo.Article;
import com.wzr.foodculture.pojo.Collect;

import java.util.List;

public interface CollectService {
    //根据用户ID查找已收藏文章
    public List<Article> findArticles(Integer uid);
    //根据aid和uid查询记录是否存在
    public Integer findId(Integer uid,Integer aid);
    //新增收藏记录
    public int addCollect(Collect collect);
    //删除收藏记录
    public int deleteCollect(Integer uid,Integer aid);
}
