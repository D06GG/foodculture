package com.wzr.foodculture.service.impl;

import com.wzr.foodculture.dao.ArticleMapper;
import com.wzr.foodculture.dao.CollectMapper;
import com.wzr.foodculture.pojo.Article;
import com.wzr.foodculture.pojo.Collect;
import com.wzr.foodculture.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {

    @Autowired
    CollectMapper collectMapper;
    @Autowired
    ArticleMapper articleMapper;

    @Override
    public List<Article> findArticles(Integer uid) {
        //初始化文章列表对象用于储存查询结果
        List<Article> articles = new ArrayList<>();
        //在用户收藏表中查找用户收藏的文章ID
        List<Integer> aids = collectMapper.selectCollectByUid(uid);
        //判断是否查询到结果，即用户是否收藏文章
        if(aids.size()>0){
            //根据查询到的用户收藏的文章ID列表再次查询，将其转换为文章列表
            for(int i = 0 ; i < aids.size();i++){
                //从文章ID列表中获取文章ID并赋值给aid
                Integer aid = aids.get(i);
                //根据文章ID查询文章，并将查询结果赋值给art
                Article art = articleMapper.selectArticleById(aid);
                //将文章对象添加到文章列表对象中
                articles.add(art);
            }
            //返回文章列表
            return articles;
        }else {
            //没有查询结果则返回空
            return null;
        }

    }

    @Override
    public Integer findId(Integer uid, Integer aid) {
        Integer id = collectMapper.selectCollectByUidAndAid(uid, aid);
        if (id!=null){
            return id;
        }
        else return 0;
    }

    @Override
    public int addCollect(Collect collect) {
        int i = collectMapper.insertCollect(collect);
        return i;
    }

    @Override
    public int deleteCollect(Integer uid,Integer aid) {
        int i = collectMapper.deleteCollect(uid,aid);
        return i;
    }
}
