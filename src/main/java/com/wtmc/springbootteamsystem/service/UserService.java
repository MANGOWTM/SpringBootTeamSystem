package com.wtmc.springbootteamsystem.service;

import com.wtmc.springbootteamsystem.entity.User;
import com.wtmc.springbootteamsystem.util.Result;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserService {
    public Result Registe(User user);

    //登录
    public Result Login(User user);

    //保存用户登录状态
    public Result me();
}
