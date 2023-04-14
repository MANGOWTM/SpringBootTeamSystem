package com.wtmc.springbootteamsystem.controller;

import com.wtmc.springbootteamsystem.entity.Vo.Collect;
import com.wtmc.springbootteamsystem.service.CollectService;
import com.wtmc.springbootteamsystem.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 博客收藏接口
 */
@RestController
@RequestMapping("/collect")
public class CollectController {
    @Resource
    private CollectService service;
    //用户添加收藏博客
    @PostMapping("/addcollectBlog")
    public Result addcollectBlog(@RequestBody Collect collect) {
        return service.addcollectBlog(collect);
    }

    //通过用户id查询用户收藏的博客
    @PostMapping("/searchCollectBlog")
    public Result searchCollectBlog(@RequestParam("userId") int userId) {
        return service.searchCollectBlog(userId);
    }

    //用户删除收藏的某个博客
    @DeleteMapping("/deleteCollectBlog")
    public Result deleteCollectBlog(@RequestParam("userId") int userId ,@RequestParam("blogId") int blogId) {
        return service.deleteCollectBlog(userId,blogId);
    }
}
