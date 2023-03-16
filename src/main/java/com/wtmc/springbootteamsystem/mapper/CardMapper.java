package com.wtmc.springbootteamsystem.mapper;


import com.wtmc.springbootteamsystem.entity.Card;
import com.wtmc.springbootteamsystem.util.Result;

import java.sql.Date;
import java.util.List;

public interface CardMapper {
    public Card checkPunchIn(Date cardAttendanceTime,int cardUserId);
    public void punchIn(Card card);
    public void punchOut(Card card);
    public List<Card> searchCardByUserId(int userId,Date beginTime, Date endTime);
    public List<Integer> searchDurationByUserId(int userId, Date beginTime, Date endTime);
}
