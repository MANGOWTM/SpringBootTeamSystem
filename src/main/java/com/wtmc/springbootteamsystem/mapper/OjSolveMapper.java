package com.wtmc.springbootteamsystem.mapper;

import com.wtmc.springbootteamsystem.entity.Vo.OjSolve;

import java.util.List;

public interface OjSolveMapper {
    public List<OjSolve> searchSolveCode(int id);
    public void addSolveCode(OjSolve ojSolve);
}
