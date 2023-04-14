package com.wtmc.springbootteamsystem.mapper;

import com.wtmc.springbootteamsystem.entity.Vo.User;
import com.wtmc.springbootteamsystem.util.Result;

import java.util.Date;
import java.util.List;


public interface UserMapper {
    //注册用户
    public void Registe(User user);
    //根据用户名查询用户
    public User searchByUserName(String userName);
    public User searchByUserRealName(String userRealName);
    public List<User> searchByUserTeamId(int teamId);
    public User checkLogin(String userName,String userPassword);
}
