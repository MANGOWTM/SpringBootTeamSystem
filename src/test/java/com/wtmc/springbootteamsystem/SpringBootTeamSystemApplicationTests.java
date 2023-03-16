package com.wtmc.springbootteamsystem;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

@SpringBootTest
class SpringBootTeamSystemApplicationTests {
    @Test
    void contextLoads() {
//        PasswordEncoder pe = new BCryptPasswordEncoder();
//        String hashEncode = pe.encode("123");
//        System.out.println("加密后:"+hashEncode);
//        boolean matches = pe.matches("123", hashEncode);
//        System.out.println("验证是否匹配成功:"+matches);
    }
    @Test
    void TestDate() throws ParseException {
        Timestamp time= new Timestamp(System.currentTimeMillis());//获取系统当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStr = df.format(time);
        time = Timestamp.valueOf(timeStr);
        String dateString = df.format(new java.util.Date());
        System.out.println(dateString);
        System.out.println(timeStr);//2017-05-06 15:54:21.0
        System.out.println(df.parse(timeStr).getTime());
        System.out.println(new Timestamp(df.parse(timeStr).getTime()));
        System.out.println(time);
        System.out.println(new java.sql.Timestamp(new java.util.Date().getTime()));
    }
    

}
