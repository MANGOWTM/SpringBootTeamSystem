package com.wtmc.springbootteamsystem.controller;

import com.wtmc.springbootteamsystem.service.OjSolveService;
import com.wtmc.springbootteamsystem.service.imp.OjSolveServiceImpl;
import com.wtmc.springbootteamsystem.util.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController("/ojSolve")
public class OjSolveController {
    @Resource
    private OjSolveService service;

    //根据题目id，查询所有AC的题解
    @GetMapping("/searchSolveCode")
    public Result searchSolveCode(@RequestParam("ojProblemId") int id) {
        return service.searchSolveCode(id);
    }
}
