package com.wtmc.springbootteamsystem.entity.Eo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardEo {
    private Date cardAttendanceTime;
    private int cardDuration;
}
