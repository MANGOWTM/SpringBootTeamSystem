package com.wtmc.springbootteamsystem.service;

import com.wtmc.springbootteamsystem.entity.Card;
import com.wtmc.springbootteamsystem.util.Result;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

public interface CardService {
    public Result punchIn(HttpServletRequest request, Card card);
    public Result punchOut(Card card);
    public Result searchCardByUserRealName(String UserRealName, Date beginTime, Date endTime);
    public Result searchDurationByUserRealName(String UserRealName,Date beginTime,Date endTime);
    public Result searchDurationByTeamName(String TeamName,Date beginTime,Date endTime);
}
