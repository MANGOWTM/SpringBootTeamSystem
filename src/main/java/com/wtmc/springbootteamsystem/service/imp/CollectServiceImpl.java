package com.wtmc.springbootteamsystem.service.imp;

import com.wtmc.springbootteamsystem.entity.Collect;
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
    public Result collectBlog(Collect collect) {
        return null;
    }

    @Override
    public Result searchCollectBlog(int userId) {
        return null;
    }

    @Override
    public Result deleteCollectBlog(int userId, int blogId) {
        return null;
    }
}
