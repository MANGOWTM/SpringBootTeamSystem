package com.wtmc.springbootteamsystem.entity.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OjSolve {
    private int ojSolveId;
    private int ojSolveUserId;
    private int ojSolveProblemId;
    private String ojSolveCode;
}
