package com.wtmc.springbootteamsystem.service;

import com.wtmc.springbootteamsystem.entity.Param.SearchBlogParam;
import com.wtmc.springbootteamsystem.entity.Vo.Collect;
import com.wtmc.springbootteamsystem.util.Result;

public interface CollectService {
    //用户添加收藏博客
    public Result addcollectBlog(Collect collect);

    //通过用户id查询用户收藏的博客
    public Result searchCollectBlog(SearchBlogParam param);

    //用户删除收藏的某个博客
    public Result deleteCollectBlog(int userId , int blogId);

    //
    public Result searchCollectBlogId(int userId);
}
