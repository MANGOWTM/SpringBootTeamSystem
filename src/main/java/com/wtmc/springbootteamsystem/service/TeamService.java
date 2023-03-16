package com.wtmc.springbootteamsystem.service;

import com.wtmc.springbootteamsystem.entity.Team;
import com.wtmc.springbootteamsystem.util.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface TeamService {
    public Result addTeam(Team team);
    public Result updateTeamContent(Team team);
}
