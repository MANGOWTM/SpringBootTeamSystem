package com.wtmc.springbootteamsystem.controller;

import com.wtmc.springbootteamsystem.entity.Vo.Blog;
import com.wtmc.springbootteamsystem.service.BlogService;
import com.wtmc.springbootteamsystem.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 博客接口
 */
@RestController
@RequestMapping("/blog")
public class BlogController {
    @Resource
    private BlogService service;


    //发布博客文章
    @PostMapping("/addBlog")
    public Result addBlog(@RequestBody Blog blog) {
        return service.addBlog(blog);
    }

    //搜索博客   筛选条件包括(博客所属团队，博客文章类型，博客作者名称等),字段有值就用，为null就不用，后续mybatis写动态sql
    @GetMapping("/searchBlog")
    public Result searchBlog(@RequestParam("teamName") String teamName,@RequestParam("blogType") String blogType,@RequestParam("userRealName") String userRealName) {
        return service.searchBlog(teamName,blogType,userRealName);
    }

    //删除博客文章
    @DeleteMapping("/deleteBlog")
    public Result deleteBlog(@RequestParam("blogId") int blogId){
        return service.deleteBlog(blogId);
    }

    @PutMapping("/updateBlog")
    public Result updateBlog(@RequestBody Blog blog){
        return service.updateBlog(blog);
    }

}
