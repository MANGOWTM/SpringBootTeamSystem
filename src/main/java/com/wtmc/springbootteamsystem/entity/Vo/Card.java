package com.wtmc.springbootteamsystem.entity.Vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    private int cardId;
    private int cardUserId;
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date cardAttendanceTime;
    //Mysql中的datetime类型Java用Timestamp接收可能插入数据库会有问题(需要留意)
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp cardTimeBegin;
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp cardTimeEnd;
    private int cardDuration;
}

