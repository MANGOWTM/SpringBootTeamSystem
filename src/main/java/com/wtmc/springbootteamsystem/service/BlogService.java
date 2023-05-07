package com.wtmc.springbootteamsystem.service;

import com.wtmc.springbootteamsystem.entity.Param.SearchBlogParam;
import com.wtmc.springbootteamsystem.entity.Vo.Blog;
import com.wtmc.springbootteamsystem.util.Result;

public interface BlogService {
    public Result addBlog(Blog blog);
    public Result searchBlog(SearchBlogParam param);
    public Result deleteBlog(int blogId);
    public Result updateBlog(Blog blog);
    public Result SearchBlogById(int blogId);
}
