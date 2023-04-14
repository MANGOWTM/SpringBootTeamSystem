package com.wtmc.springbootteamsystem.controller;

import com.wtmc.springbootteamsystem.entity.Vo.User;
import com.wtmc.springbootteamsystem.service.UserService;
import com.wtmc.springbootteamsystem.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户接口
 */
@RestController//@Controller+@Response
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService service;

    //用户注册
    @PostMapping("/registe")
    public Result Registe(@RequestBody User user) {
        return service.Registe(user);
    }

    //登录
    @PostMapping("/login")
    public Result Login(@RequestBody User user){
        return service.Login(user);
    }

    //保存用户登录状态
    @GetMapping("/me")
    public Result me() {
        return Result.error("/me此功能暂未实现");
    }

}
