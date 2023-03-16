package com.wtmc.springbootteamsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//博客收藏表实体类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Collect {
    private int collectId;
    private int collectUserId;
    private int collectBlogId;
}


