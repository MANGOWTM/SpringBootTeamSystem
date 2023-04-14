package com.wtmc.springbootteamsystem.entity.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answer {
    // error 为状态码.
    // 0 编译通过
    // 1 表示编译出错
    // 2 表示运行出错
    // 3 表示其他错误
    private int error;
    // reason 为出错的提示信息.
    // error=1, reason 就是错误信息
    // error=2, reason 就是异常信息
    private String reason;
    // 运行程序得到的标准输出的结果
    private String stdout;
    // 运行程序得到的标准错误的结果
    private String stderr;

    //...一堆getter和setter 省略
}

