package com.wtmc.springbootteamsystem.controller;

import com.wtmc.springbootteamsystem.entity.Team;
import com.wtmc.springbootteamsystem.service.TeamService;
import com.wtmc.springbootteamsystem.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.temporal.Temporal;

@RestController
@RequestMapping("/team")
public class TeamController {
    @Resource
    private TeamService service;
    //添加团队
    @PostMapping("/addTeam")
    public Result addTeam(@RequestBody Team team) {
        return service.addTeam(team);
    }

    //修改团队简介
    @PutMapping("/updateTeamContent")
    public Result updateTeamContent(@RequestBody Team team){
        return service.updateTeamContent(team);
    }
}
