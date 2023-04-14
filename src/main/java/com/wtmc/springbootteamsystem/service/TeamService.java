package com.wtmc.springbootteamsystem.service;

import com.wtmc.springbootteamsystem.entity.Vo.Team;
import com.wtmc.springbootteamsystem.util.Result;

public interface TeamService {
    public Result addTeam(Team team);
    public Result updateTeamContent(Team team);
}
