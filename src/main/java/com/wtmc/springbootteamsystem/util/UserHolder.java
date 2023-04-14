package com.wtmc.springbootteamsystem.util;

import com.wtmc.springbootteamsystem.entity.Vo.User;

//保留用户状态(HTTP是无状态协议)
public class UserHolder {
    private static ThreadLocal<User> tl = new ThreadLocal<>();

    public void saveUser(User user) {
        tl.set(user);
    }

    public User getUser() {
        return tl.get();
    }

    public void removeUser() {
        tl.remove();
    }
}
