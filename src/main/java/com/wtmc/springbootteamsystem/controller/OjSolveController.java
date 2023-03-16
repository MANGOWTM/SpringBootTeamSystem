package com.wtmc.springbootteamsystem.controller;

import com.wtmc.springbootteamsystem.util.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/ojSolve")
public class OjSolveController {
    //根据题目id，查询所有AC的题解
    @GetMapping("/searchSolveCode")
    public Result searchSolveCode(@RequestParam("ojProblemId") int id) {
        return Result.error("/searchSolveCode未开发");
    }
}
