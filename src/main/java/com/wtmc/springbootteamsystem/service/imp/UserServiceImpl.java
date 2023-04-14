package com.wtmc.springbootteamsystem.service.imp;

import com.wtmc.springbootteamsystem.entity.Vo.User;
import com.wtmc.springbootteamsystem.mapper.UserMapper;
import com.wtmc.springbootteamsystem.service.UserService;
import com.wtmc.springbootteamsystem.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper dao;
    @Override
    public Result Registe(User user) {
        User user1 = dao.searchByUserName(user.getUserName());
        if(user1==null){
            dao.Registe(user);
            return Result.ok("注册成功");
        }
        //用户名被注册了
        return Result.error("用户名已经被注册");
    }

    @Override
    public Result Login(User user) {
        //获取用户姓名和密码(userName和userPassword是否为空在前端判断)
        String userName = user.getUserName();
        String userPassword = user.getUserPassword();
        //根据用户名和密码查询用户
        User user1 = dao.checkLogin(userName, userPassword);
        //如果用户不存在
        if(user1==null) {
            return Result.error("用户名不存在或密码错误!");
        }
        else{
            return Result.ok("登录成功",user1);
        }
    }

    @Override
    public Result me() {
        return null;
    }
}
