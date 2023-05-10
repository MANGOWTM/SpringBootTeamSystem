package com.wtmc.springbootteamsystem.entity.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OjProblem {
    private int ojProblemId;
    private String ojProblemTitle;
    private String ojProblemLevel;
    private String ojProblemType;
    private String ojProblemDescription;
    private String ojProblemTemplateCode;
    private String ojProblemTestCode;
    private String ojProblemTeam;
    private Integer ojProblemScore;
}
