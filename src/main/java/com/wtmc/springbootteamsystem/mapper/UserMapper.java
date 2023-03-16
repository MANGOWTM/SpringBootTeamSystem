package com.wtmc.springbootteamsystem.mapper;

import com.wtmc.springbootteamsystem.entity.User;
import com.wtmc.springbootteamsystem.util.Result;


public interface UserMapper {
    //注册用户
    public void Registe(User user);
    //根据用户名查询用户
    public User searchByUserName(String userName);
    public User searchByUserRealName(String userRealName);
    public User checkLogin(String userName,String userPassword);

    public Result me();
}
