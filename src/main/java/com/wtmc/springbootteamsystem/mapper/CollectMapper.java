package com.wtmc.springbootteamsystem.mapper;

import com.wtmc.springbootteamsystem.entity.Vo.Collect;

public interface CollectMapper {
    public void addcollectBlog(Collect collect);
    public Collect searchCollectBlog(int userId);
    public void deleteCollectBlog(int userId,int blogId);
}
