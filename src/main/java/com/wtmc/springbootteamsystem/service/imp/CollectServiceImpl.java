package com.wtmc.springbootteamsystem.service.imp;

import com.wtmc.springbootteamsystem.entity.Vo.Collect;
import com.wtmc.springbootteamsystem.mapper.CollectMapper;
import com.wtmc.springbootteamsystem.service.CollectService;
import com.wtmc.springbootteamsystem.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CollectServiceImpl implements CollectService {
    @Resource
    private CollectMapper dao;
    @Override
    public Result addcollectBlog(Collect collect) {
        dao.addcollectBlog(collect);
        return Result.ok("收藏博客成功",collect);
    }

    @Override
    public Result searchCollectBlog(int userId) {
        Collect collect = dao.searchCollectBlog(userId);
        return Result.ok("博客收藏表查询成功",collect);
    }

    @Override
    public Result deleteCollectBlog(int userId, int blogId) {
        dao.deleteCollectBlog(userId,blogId);
        return Result.ok("博客取消收藏成功");
    }
}
