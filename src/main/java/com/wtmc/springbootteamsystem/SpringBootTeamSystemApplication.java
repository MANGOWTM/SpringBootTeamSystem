package com.wtmc.springbootteamsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(basePackages = "com.wtmc.springbootteamsystem.mapper")
public class SpringBootTeamSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTeamSystemApplication.class, args);
    }

}
