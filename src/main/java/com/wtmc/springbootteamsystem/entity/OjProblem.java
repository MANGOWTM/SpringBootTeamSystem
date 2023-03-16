package com.wtmc.springbootteamsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OjProblem {
    private int ojProblemId;
    private String ojProlemTitle;
    private String ojProblemLevel;
    private String ojProblemType;
    private String ojProblemDescription;
    private String ojProblemTemplateCode;
    private String ojProblemTestCode;
    private String ojProblemTeam;
}
