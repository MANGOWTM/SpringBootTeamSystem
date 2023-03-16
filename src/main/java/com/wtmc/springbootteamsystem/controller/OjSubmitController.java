package com.wtmc.springbootteamsystem.controller;

import com.wtmc.springbootteamsystem.entity.OjSubmit;
import com.wtmc.springbootteamsystem.util.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/ojSubmit")
public class OjSubmitController {
    //OJ测试题目(别人提交的代码进行题目测试)
    @PostMapping("/submitTest")
    public Result submitTest(@RequestBody OjSubmit ojSubmit) {
        //1.如果题目通过测试，那么把AC代码添加到oj_solve表中,这个由service层来处理
        return Result.error("/submitTest未开发");
    }
}
