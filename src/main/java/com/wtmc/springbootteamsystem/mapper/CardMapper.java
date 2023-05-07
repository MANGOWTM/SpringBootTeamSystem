package com.wtmc.springbootteamsystem.mapper;


import com.wtmc.springbootteamsystem.entity.Eo.CardEo;
import com.wtmc.springbootteamsystem.entity.Vo.Card;

import java.util.Date;
import java.util.List;

public interface CardMapper {
    public Card checkPunchIn(Date cardAttendanceTime,int cardUserId);
    public void punchIn(Card card);
    public void punchOut(Card card);
    public List<Card> searchCardByUserId(int userId,Date beginTime, Date endTime);
    public List<CardEo> searchDurationByUserId(int userId, Date beginTime, Date endTime);
}
