package com.wtmc.springbootteamsystem.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    private int blogId;
    private int blogUserId;
    private int blogTeamId;
    //Mysql的set类型，Java用blogType接收(可能自动封装的时候会存在问题)
    private String blogType;
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp blogCreateDate;
    private String blogTitle;
    private String blogContent;
    private int blogRead;
    private int blogLike;
    private int blogCollect;
}
