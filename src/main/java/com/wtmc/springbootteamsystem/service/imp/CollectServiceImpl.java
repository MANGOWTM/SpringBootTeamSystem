package com.wtmc.springbootteamsystem.service.imp;

import com.wtmc.springbootteamsystem.entity.Dto.BlogDto;
import com.wtmc.springbootteamsystem.entity.Param.SearchBlogParam;
import com.wtmc.springbootteamsystem.entity.Vo.Blog;
import com.wtmc.springbootteamsystem.entity.Vo.Collect;
import com.wtmc.springbootteamsystem.entity.Vo.User;
import com.wtmc.springbootteamsystem.mapper.BlogMapper;
import com.wtmc.springbootteamsystem.mapper.CollectMapper;
import com.wtmc.springbootteamsystem.mapper.UserMapper;
import com.wtmc.springbootteamsystem.service.CollectService;
import com.wtmc.springbootteamsystem.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {
    @Resource
    private CollectMapper dao;
    @Resource
    private BlogMapper blogDao;
    @Resource
    private UserMapper userDao;
    @Override
    public Result addcollectBlog(Collect collect) {
        dao.addcollectBlog(collect);
        return Result.ok("收藏博客成功",collect);
    }

    @Override
    public Result searchCollectBlog(SearchBlogParam param) {
        System.out.println(param);
        int userId = param.getUserId();
        List<Integer> ids = dao.searchCollectBlog(userId);
        Integer currentPage = param.getCurrentPage();
        Integer pageSize = param.getPageSize();
        List<Blog> collectBlogs = blogDao.searchBlogByListId(ids,(currentPage-1)*pageSize,pageSize);
        BlogDto blogDto = new BlogDto();
        blogDto.setBlogLists(collectBlogs);
        blogDto.setCurrentPage(currentPage);
        blogDto.setPageSize(pageSize);
        blogDto.setTotal(blogDao.selectCount());
        return Result.ok("博客收藏表查询成功",blogDto);
    }

    @Override
    public Result deleteCollectBlog(int userId, int blogId) {
        dao.deleteCollectBlog(userId,blogId);
        return Result.ok("博客取消收藏成功");
    }

    @Override
    public Result searchCollectBlogId(int userId) {
        List<Integer> list = dao.searchCollectBlogId(userId);
        return Result.ok("查询博客ID成功",list);
    }
}
