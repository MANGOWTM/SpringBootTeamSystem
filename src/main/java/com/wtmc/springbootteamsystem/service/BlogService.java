package com.wtmc.springbootteamsystem.service;

import com.wtmc.springbootteamsystem.entity.Blog;
import com.wtmc.springbootteamsystem.util.Result;

public interface BlogService {
    public Result addBlog(Blog blog);
    public Result searchBlog(String teamName, String blogType, String userRealName);
}
