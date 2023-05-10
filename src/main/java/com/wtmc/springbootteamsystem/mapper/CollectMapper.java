package com.wtmc.springbootteamsystem.mapper;

import com.wtmc.springbootteamsystem.entity.Vo.Collect;

import java.util.List;

public interface CollectMapper {
    public void addcollectBlog(Collect collect);
    public List<Integer> searchCollectBlog(int userId);
    public void deleteCollectBlog(int userId,int blogId);
    public List<Integer> searchCollectBlogId(int userId);
}
