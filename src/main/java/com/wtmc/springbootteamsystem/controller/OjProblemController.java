package com.wtmc.springbootteamsystem.controller;

import com.wtmc.springbootteamsystem.entity.OjComment;
import com.wtmc.springbootteamsystem.entity.OjProblem;
import com.wtmc.springbootteamsystem.entity.OjSubmit;
import com.wtmc.springbootteamsystem.util.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/OjProblem")
public class OjProblemController {
    //OJ出题(数据上传通过addTestData方法来上传)
    @PostMapping("/addProblem")
    public Result addProblem(@RequestBody OjProblem ojProblem) {
        return Result.error("/addProblem未开发");
    }

    @PostMapping("/addTestData")
    //OJ题目测试数据上传(数据采用.txt文本形式长传),然后把.txt通过IO保存到服务器指定文件夹下
    public Result addTestData(@RequestParam("file") MultipartFile file) {
        return Result.error("/addTestData未开发");
    }
    //根据题目id，删除题目
    @DeleteMapping("/deleteProblem")
    public Result deleteProblem(@RequestParam("ojProblemId") int id) {
        //删除题目的同时删除测试数据.txt文件
        return Result.error("/deleteProblem未开发");
    }

}
