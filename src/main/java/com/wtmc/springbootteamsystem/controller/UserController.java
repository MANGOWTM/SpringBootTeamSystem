package com.wtmc.springbootteamsystem.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
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

    //查询用户登录状态，浏览器访问：http://localhost:8081/user/isLogin
    @GetMapping("/isLogin")
    public Result isLogin() {
        return Result.ok("当前会话是否登录：" + StpUtil.isLogin());
    }

    //保存用户登录状态
    @GetMapping("/me")
    public Result me() {
        return Result.error("/me此功能暂未实现");
    }
    //退出登录
    @GetMapping("/logout")
    public Result logout() {
        StpUtil.logout();
        return Result.ok("退出登录");
    }

}
