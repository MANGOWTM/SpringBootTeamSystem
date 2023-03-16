package com.wtmc.springbootteamsystem.mapper;

import com.wtmc.springbootteamsystem.entity.Collect;

public interface CollectMapper {
    public void collectBlog(Collect collect);
    public Collect searchCollectBlog(int userId);
    public void deleteCollectBlog(int userId,int blogId);
}
