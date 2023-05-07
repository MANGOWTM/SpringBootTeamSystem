package com.wtmc.springbootteamsystem.mapper;

import com.wtmc.springbootteamsystem.entity.Vo.Blog;

import java.util.List;

public interface BlogMapper {
    public void addBlog(Blog blog);
    public List<Blog> searchBlog(int teamId, String blogType, int blogUserId, int beginPos, int pageSize);
    public Blog SearchBlogById(int blogId);
    public void deleteBlog(int blogId);
    public int selectCount();
}
