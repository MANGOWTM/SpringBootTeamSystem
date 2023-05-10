package com.wtmc.springbootteamsystem.service.imp;

import com.wtmc.springbootteamsystem.entity.Eo.OjProblemEo;
import com.wtmc.springbootteamsystem.entity.Vo.OjProblem;
import com.wtmc.springbootteamsystem.mapper.OjProblemMapper;
import com.wtmc.springbootteamsystem.service.OjProblemService;
import com.wtmc.springbootteamsystem.util.Result;
import org.apache.commons.lang3.StringUtils;
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
        String ojProblemLevel = ojProblem.getOjProblemLevel();
        int score = 10;
        if(StringUtils.isNotEmpty(ojProblemLevel)) {
            if(ojProblemLevel.equals("简单")) score = 10;
            else if(ojProblemLevel.equals("一般")) score = 30;
            else score = 50;
        }
        ojProblem.setOjProblemScore(score);
        return Result.ok("题目添加成功",ojProblem);
    }

    //添加数据采用文件IO方式不走数据库，直接存到服务器文件上
    @Override
    public Result addTestData(MultipartFile file) {
        return null;
    }

    @Override
    public Result deleteProblem(int id) {
        dao.deleteProblem(id);
        return Result.ok("删除题目成功");

    }

    @Override
    public Result searchProblem(OjProblemEo ojProblemEo) {
        List<OjProblem> ojProblems = dao.searchProblem(ojProblemEo);
        return Result.ok("查询题目成功",ojProblems);
    }

    @Override
    public Result searchProblemById(int ojProblemId) {
        OjProblem ojProblem = dao.searchProblemById(ojProblemId);
        return Result.ok("查询题目成功",ojProblem);
    }
}
