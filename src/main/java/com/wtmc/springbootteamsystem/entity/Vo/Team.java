package com.wtmc.springbootteamsystem.entity.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    private int teamId;
    private String teamName;
    private String teamContent;
}

