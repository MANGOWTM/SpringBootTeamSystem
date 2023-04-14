package com.wtmc.springbootteamsystem.controller;

import com.wtmc.springbootteamsystem.entity.Vo.Card;
import com.wtmc.springbootteamsystem.service.CardService;
import com.wtmc.springbootteamsystem.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

/**
 * 打卡接口
 */
@RestController
@RequestMapping("/card")
public class CardController {
    @Resource
    private CardService service;
    //上班打卡
    @PostMapping("/punchIn")
    public Result punchIn(@RequestBody Card card, HttpServletRequest request) {
        return service.punchIn(request,card);
    }

    @PostMapping("/punchOut")
    //下班打卡
    public Result punchOut(@RequestBody Card card,HttpServletRequest request) {
        return service.punchOut(card);
    }



    //根据用户真实姓名查询打卡记录，(支持日期范围查询)
    @GetMapping("/searchCardByUserRealName")
    public Result searchCardByUserRealName(@RequestParam("userRealName") String userRealName,@RequestParam("beginTime") Date beginTime,@RequestParam("endTime") Date endTime){
        return service.searchCardByUserRealName(userRealName,beginTime,endTime);
    }


    //根据用户真实姓名，查询打卡时长(可根据日期进行范围打卡总时长查询)
    @GetMapping("/searchDurationByUserRealName")
    public Result searchDurationByUserRealName(@RequestParam("userRealName") String userRealName,@RequestParam("beginTime") Date beginTime,@RequestParam("endTime") Date endTime) {
        return service.searchDurationByUserRealName(userRealName,beginTime,endTime);
    }

    //根据团队名称，查询团队所有成员打卡时长(可根据日期进行范围打卡总时长查询)
    @GetMapping("/searchDurationByTeamName")
    public Result searchDurationByTeamName(@RequestParam("teamName") String teamName,@RequestParam("beginTime") Date  beginTime,@RequestParam("endTime") Date endTime) {
        return service.searchDurationByTeamName(teamName,beginTime,endTime);
    }
}
