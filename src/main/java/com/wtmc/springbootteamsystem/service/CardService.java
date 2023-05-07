package com.wtmc.springbootteamsystem.service;

import com.wtmc.springbootteamsystem.entity.Vo.Card;
import com.wtmc.springbootteamsystem.util.Result;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public interface CardService {
    public Result punchIn(HttpServletRequest request, Card card);
    public Result punchOut(Card card);
    public Result searchCardByUserRealName(String UserRealName, Date beginTime, Date endTime);
    public Result searchDurationByUserRealName(String UserRealName,Date beginTime,Date endTime);
    public Result searchDurationByTeamName(String TeamName,Date beginTime,Date endTime);
    public Result searchCardByUserId(Integer userId,Date beginTime,Date endTime);
}
