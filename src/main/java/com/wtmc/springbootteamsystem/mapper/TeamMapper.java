package com.wtmc.springbootteamsystem.mapper;

import com.wtmc.springbootteamsystem.entity.Vo.Team;

public interface TeamMapper {
    public void addTeam(Team team);
    public Team searchTeamByName(String teamName);
    public void deleteByTeamId(int teamId);
}
