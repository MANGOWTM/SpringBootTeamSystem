package com.wtmc.springbootteamsystem.service.imp;

import com.wtmc.springbootteamsystem.entity.Vo.Team;
import com.wtmc.springbootteamsystem.mapper.TeamMapper;
import com.wtmc.springbootteamsystem.service.TeamService;
import com.wtmc.springbootteamsystem.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TeamServiceImpl implements TeamService {
    @Resource
    private TeamMapper dao;
    @Override
    public Result addTeam(Team team) {
        //1.先查询团队是否存在,用团队名称查询，因为名称是unique修饰字段
        String teamName = team.getTeamName();
        Team teamCheck = dao.searchTeamByName(teamName);
        //2.如果不存在,就添加
        if(teamCheck == null) {
            dao.addTeam(team);
            return Result.ok("团队添加成功",team);
        }
        //3.如果存在就直接返回
        else {
            return Result.error("团队已经存在(团队名称重复)!");
        }
    }

    @Override
    public Result updateTeamContent(Team team) {
        //1.首先拿到teamId,用teamId找到对应的team然后删除，再添加
        int teamId = team.getTeamId();
        dao.deleteByTeamId(teamId);
        System.out.println(teamId);
        //2.拿到teamName查看团队是否存在
        String teamName = team.getTeamName();
        Team teamCheck = dao.searchTeamByName(teamName);
        //3.不存在，则添加
        if(teamCheck == null) {
            dao.addTeam(team);
            return Result.ok("修改成功",team);
        }
        //存在就提示已经存在
        else {
            return Result.error("团队已经存在(团队名称重复)!");
        }
    }
}
