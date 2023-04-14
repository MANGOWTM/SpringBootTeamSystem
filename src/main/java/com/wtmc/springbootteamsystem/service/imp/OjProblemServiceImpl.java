package com.wtmc.springbootteamsystem.service.imp;

import com.wtmc.springbootteamsystem.entity.Eo.OjProblemEo;
import com.wtmc.springbootteamsystem.entity.Vo.OjProblem;
import com.wtmc.springbootteamsystem.mapper.OjProblemMapper;
import com.wtmc.springbootteamsystem.service.OjProblemService;
import com.wtmc.springbootteamsystem.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;


@Service
public class OjProblemServiceImpl implements OjProblemService {
    @Resource
    private OjProblemMapper dao;

    @Override
    public Result addProblem(OjProblem ojProblem) {
        dao.addProblem(ojProblem);
        return null;
    }

    //添加数据采用文件IO方式不走数据库，直接存到服务器文件上
    @Override
    public Result addTestData(MultipartFile file) {
        return null;
    }

    @Override
    public Result deleteProblem(int id) {
        dao.deleteProblem(id);
        return null;
    }

    @Override
    public Result searchProblem(OjProblemEo ojProblemEo) {
        List<OjProblem> ojProblems = dao.searchProblem(ojProblemEo);
        return Result.ok("查询题目成功",ojProblems);
    }
}
