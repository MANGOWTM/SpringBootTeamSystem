package com.wtmc.springbootteamsystem.service.imp;

import com.wtmc.springbootteamsystem.entity.Vo.Blog;
import com.wtmc.springbootteamsystem.entity.Vo.Team;
import com.wtmc.springbootteamsystem.entity.Vo.User;
import com.wtmc.springbootteamsystem.mapper.BlogMapper;
import com.wtmc.springbootteamsystem.mapper.TeamMapper;
import com.wtmc.springbootteamsystem.mapper.UserMapper;
import com.wtmc.springbootteamsystem.service.BlogService;
import com.wtmc.springbootteamsystem.util.DateUtil;
import com.wtmc.springbootteamsystem.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;

@Service
public class BlogServiceImpl implements BlogService {
    @Resource
    private BlogMapper blogDao;
    @Resource
    private TeamMapper teamDao;
    @Resource
    private UserMapper userDao;

    @Override
    public Result addBlog(Blog blog) {
        //获取当前系统时间作为博客发布时间
        Timestamp timestamp = DateUtil.getTimestamp();
        blog.setBlogCreateDate(timestamp);
        blogDao.addBlog(blog);
        return Result.ok("博客添加成功",blog);
    }

    @Override
    public Result searchBlog(String teamName, String blogType, String userRealName) {
        //1.根据teamName查询出teamId
        int teamId = -1,userId = -1;
        Team team = teamDao.searchTeamByName(teamName);
        if(team != null) {
            teamId = team.getTeamId();
        }
        //2.根据userRealName查询出userId
        User user = userDao.searchByUserRealName(userRealName);
        if(user != null) {
            userId = user.getUserId();
        }
        Blog blog = blogDao.searchBlog(teamId, blogType, userId);
        return Result.ok("博客查询成功",blog);
    }

    @Override
    public Result deleteBlog(int blogId) {
        blogDao.deleteBlog(blogId);
        return Result.ok("博客删除成功",blogId);
    }

    @Override
    public Result updateBlog(Blog blog) {
        int id = blog.getBlogId();
        blogDao.deleteBlog(id);
        blogDao.addBlog(blog);
        return Result.ok("修改博客成功",blog);
    }
}
