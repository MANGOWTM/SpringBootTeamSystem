package com.wtmc.springbootteamsystem.service.imp;

import com.wtmc.springbootteamsystem.entity.Blog;
import com.wtmc.springbootteamsystem.entity.Team;
import com.wtmc.springbootteamsystem.entity.User;
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
    private BlogMapper dao;
    @Resource
    private TeamMapper teamDao;
    @Resource
    private UserMapper userDao;

    @Override
    public Result addBlog(Blog blog) {
        //获取当前系统时间作为博客发布时间
        Timestamp timestamp = DateUtil.getTimestamp();
        blog.setBlogCreateDate(timestamp);
        dao.addBlog(blog);
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
        Blog blog = dao.searchBlog(teamId, blogType, userId);
        return Result.ok("博客查询成功",blog);
    }
}
