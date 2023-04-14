package com.wtmc.springbootteamsystem;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.wtmc.springbootteamsystem.util.AESUtils;
import com.wtmc.springbootteamsystem.util.CommandUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

    @Test
    void TestCmd() {
        CommandUtil.run("javac","stdout.txt","stderr.txt");
    }

    @Test
    void testCompile() {
//        Task task = new Task();
//        Answer answer = task.compileAndRun();
//        System.out.println(answer.getStdout());
    }

    @Test
    void testDeleteFile() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", "John");
        jSONObject.put("age", 30);
        jSONObject.put("address", null);

        String jsonString = JSONObject.toJSONString(jSONObject, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue);
        System.out.println(jsonString);
    }
    @Test
    void  testGetKey() throws Exception {
        System.out.println(AESUtils.generateKey());
    }

    @Test
    void testDecrypt() throws Exception {
        String hello_world = AESUtils.encrypt("hello world 你好啊", "tQUPqnqkOe7ptgmJHewQ9g==");
        System.out.println("加密的原始数据:"+hello_world);
        String info = AESUtils.decrypt(hello_world, "tQUPqnqkOe7ptgmJHewQ9g==");
        System.out.println("解密后的数据:"+info);
//        aDL2IOiuknBNkiXP+MBOrg==
    }

}
