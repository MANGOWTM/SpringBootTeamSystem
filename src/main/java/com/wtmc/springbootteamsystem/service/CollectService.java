package com.wtmc.springbootteamsystem.service;

import com.wtmc.springbootteamsystem.entity.Collect;
import com.wtmc.springbootteamsystem.util.Result;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface CollectService {
    //用户添加收藏博客
    public Result collectBlog(Collect collect);

    //通过用户id查询用户收藏的博客
    public Result searchCollectBlog(int userId);

    //用户删除收藏的某个博客
    public Result deleteCollectBlog(int userId , int blogId);
}
