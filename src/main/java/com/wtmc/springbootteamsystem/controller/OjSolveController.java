package com.wtmc.springbootteamsystem.controller;

import com.wtmc.springbootteamsystem.entity.Vo.OjSolve;
import com.wtmc.springbootteamsystem.service.OjSolveService;
import com.wtmc.springbootteamsystem.service.imp.OjSolveServiceImpl;
import com.wtmc.springbootteamsystem.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * OJ题目AC接口
 */
@RestController
@RequestMapping("/ojSolve")
public class OjSolveController {
    @Resource
    private OjSolveService service;

    //根据题目id，查询所有AC的题解
    @GetMapping("/searchSolveCode")
    public Result searchSolveCode(@RequestParam("ojProblemId") int id) {
        return service.searchSolveCode(id);
    }
    //添加AC题解
    @PostMapping("/addSolveCode")
    public Result addSolveCode(@RequestBody OjSolve ojSolve){
        return service.addSolveCode(ojSolve);
    }
}
