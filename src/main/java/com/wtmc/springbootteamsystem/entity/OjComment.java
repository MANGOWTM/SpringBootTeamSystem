package com.wtmc.springbootteamsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OjComment {
    private int ojCommentId;
    private int ojCommentSolveId;
    private int ohCommentUserId;
    private String ojCommentContent;
    private Timestamp ojCommentDate;
}
