package com.wtmc.springbootteamsystem.service.imp;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
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
        System.out.println(user);
        //用户名没有被注册
        if(user1==null){
            //密码加密
            user.setUserPassword(SaSecureUtil.md5(user.getUserPassword()));
            user.setUserPosition("普通用户");
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
        //md5加密
        String userPassword = SaSecureUtil.md5(user.getUserPassword());
        //根据用户名和密码查询用户
        User checkUser = dao.checkLogin(userName, userPassword);
        //如果用户不存在
        if(checkUser==null) {
            return Result.error("用户名不存在或密码错误!",user);
        }
        else{
            //会话登录，userId作为会话id
            StpUtil.login(user.getUserId(),100000000);
            //获取token，返回给前端
            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
            return Result.ok("登录成功",checkUser,tokenInfo);
        }
    }

    @Override
    public Result me() {
        return null;
    }
}
