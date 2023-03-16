package com.wtmc.springbootteamsystem.util;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {
    public static Timestamp getTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
    public static Date getDate(String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);//日期格式化
        String datef = sdf.format(new java.util.Date());
        return new Date(sdf.parse(datef).getTime());
    }
    //通过计算学习时长(单位分钟)
    public static int getTimeDuration(Timestamp start , Timestamp end) {
        return (int) ((end.getTime()-start.getTime())/(1000*60));
    }
}
