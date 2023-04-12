package com.wtmc.springbootteamsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//封装用户刷题提交测试的代码
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OjSubmit {
    //题目id
    private int ojProblemId;
    //用户代码
    private String ojSubmitCode;
}
