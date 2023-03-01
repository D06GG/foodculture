package com.wzr.foodculture.dao;

import com.wzr.foodculture.pojo.Collect;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectMapper {
    //根据用户ID查找文章ID
    public List<Integer> selectCollectByUid(Integer uid);
    //根据aid和uid查询记录是否存在
    public Integer selectCollectByUidAndAid(@Param("uid")Integer uid, @Param("aid")Integer aid);
    //新增收藏记录
    public int insertCollect(Collect collect);
    //删除收藏记录
    public int deleteCollect(@Param("uid")Integer uid,@Param("aid")Integer aid);
}
