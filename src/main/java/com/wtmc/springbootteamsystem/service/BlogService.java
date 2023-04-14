package com.wtmc.springbootteamsystem.service;

import com.wtmc.springbootteamsystem.entity.Vo.Blog;
import com.wtmc.springbootteamsystem.util.Result;

public interface BlogService {
    public Result addBlog(Blog blog);
    public Result searchBlog(String teamName, String blogType, String userRealName);
    public Result deleteBlog(int blogId);
    public Result updateBlog(Blog blog);
}
