package com.wtmc.springbootteamsystem.mapper;

import com.wtmc.springbootteamsystem.entity.Team;
import com.wtmc.springbootteamsystem.util.Result;
import org.springframework.web.bind.annotation.RequestBody;

public interface TeamMapper {
    public void addTeam(Team team);
    public Team searchTeamByName(String teamName);
    public void deleteByTeamId(int teamId);
}
