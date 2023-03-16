package com.wtmc.springbootteamsystem.mapper;

import com.wtmc.springbootteamsystem.entity.Blog;

public interface BlogMapper {
    public void addBlog(Blog blog);
    public Blog searchBlog(int teamId, String blogType, int blogUserId);
}
