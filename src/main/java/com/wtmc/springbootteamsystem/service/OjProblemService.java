package com.wtmc.springbootteamsystem.service;

import com.wtmc.springbootteamsystem.entity.Eo.OjProblemEo;
import com.wtmc.springbootteamsystem.entity.Vo.OjProblem;
import com.wtmc.springbootteamsystem.util.Result;
import org.springframework.web.multipart.MultipartFile;

public interface OjProblemService {
    public Result addProblem(OjProblem ojProblem);
    public Result addTestData(MultipartFile file);
    public Result deleteProblem(int id);
    public Result searchProblem(OjProblemEo ojProblemEo);
}
