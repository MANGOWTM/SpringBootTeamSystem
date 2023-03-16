package com.wtmc.springbootteamsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

//博客评论表实体类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private int commentId;
    private int commentUserId;
    private int commentBlogId;
    private String commentContent;
    private Timestamp commentCreateDate;
}
