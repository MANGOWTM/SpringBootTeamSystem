package com.wtmc.springbootteamsystem.service;

import com.wtmc.springbootteamsystem.entity.Vo.User;
import com.wtmc.springbootteamsystem.util.Result;

public interface UserService {
    public Result Registe(User user);

    //登录
    public Result Login(User user);

    //保存用户登录状态
    public Result me();
}
