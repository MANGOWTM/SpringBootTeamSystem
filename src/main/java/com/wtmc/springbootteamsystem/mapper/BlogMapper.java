package com.wtmc.springbootteamsystem.mapper;

import com.wtmc.springbootteamsystem.entity.Vo.Blog;

public interface BlogMapper {
    public void addBlog(Blog blog);
    public Blog searchBlog(int teamId, String blogType, int blogUserId);
    public void deleteBlog(int blogId);
}
