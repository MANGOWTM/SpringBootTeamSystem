package com.wtmc.springbootteamsystem.service;

import com.wtmc.springbootteamsystem.util.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface OjSolveService {
    //根据题目id，查询所有AC的题解
    public Result searchSolveCode(int id);
}
