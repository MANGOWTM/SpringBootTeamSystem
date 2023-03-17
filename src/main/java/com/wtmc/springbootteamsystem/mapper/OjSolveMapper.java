package com.wtmc.springbootteamsystem.mapper;

import com.wtmc.springbootteamsystem.entity.OjSolve;
import com.wtmc.springbootteamsystem.util.Result;

import java.util.List;

public interface OjSolveMapper {
    public List<OjSolve> searchSolveCode(int id);
}
