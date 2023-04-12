package com.wtmc.springbootteamsystem.service.imp;

import com.wtmc.springbootteamsystem.entity.OjSolve;
import com.wtmc.springbootteamsystem.mapper.OjSolveMapper;
import com.wtmc.springbootteamsystem.service.OjSolveService;
import com.wtmc.springbootteamsystem.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OjSolveServiceImpl implements OjSolveService {
    @Resource
    private OjSolveMapper dao;

    @Override
    public Result searchSolveCode(int id) {
        List<OjSolve> ojSolves = dao.searchSolveCode(id);
        return Result.ok("题解查询成功",ojSolves);
    }
}
