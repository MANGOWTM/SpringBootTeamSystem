package com.wtmc.springbootteamsystem.service.imp;


import com.wtmc.springbootteamsystem.entity.Dto.CardDto;
import com.wtmc.springbootteamsystem.entity.Eo.CardEo;
import com.wtmc.springbootteamsystem.entity.Vo.Card;
import com.wtmc.springbootteamsystem.entity.Vo.Team;
import com.wtmc.springbootteamsystem.entity.Vo.User;
import com.wtmc.springbootteamsystem.mapper.CardMapper;
import com.wtmc.springbootteamsystem.mapper.TeamMapper;
import com.wtmc.springbootteamsystem.mapper.UserMapper;
import com.wtmc.springbootteamsystem.service.CardService;
import com.wtmc.springbootteamsystem.util.DateUtil;
import com.wtmc.springbootteamsystem.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CardServiceImpl implements CardService {
    @Resource
    private CardMapper cardDao;
    @Resource
    private UserMapper userDao;
    @Resource
    private TeamMapper teamDao;

    @Override
    public Result punchIn(HttpServletRequest request,Card card) {
        //获取用户IP判断用户是否使用的团队WIFI，客户端的所有请求信息都可以通过HttpServletRequest获得（包括IP地址）

        Date sqlDate = null;
        try {
            //1.先获取考勤日时间(用于判断同一天是否重复打卡)，考勤日精确到yyyy:MM:dd
            sqlDate = DateUtil.getDate("yyyy:MM:dd");
            System.out.println(sqlDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //2.通过考勤日搜索上班打卡，如果为空，那么说明还没有上班打卡，那么获取打卡时间进行打卡
        Card cardCheck = cardDao.checkPunchIn(sqlDate,card.getCardUserId());
        if(cardCheck == null) {
            card.setCardAttendanceTime(sqlDate);
            card.setCardTimeBegin(DateUtil.getTimestamp());
            cardDao.punchIn(card);
            return Result.ok("打卡成功",card);
        }
        //3.如果已经上班打卡过了，返回fail
        else {
            return Result.error("您今天上班打过卡了哟!");
        }
    }

    @Override
    public Result punchOut(Card card) {
         /*获取用户IP判断用户是否使用的团队WIFI，客户端的所有请求信息都可以通过HttpServletRequest获得（包括IP地址）,然后再获取wifi下的所有连接设备的ip，
        然后对比查看是否有客户端的ip就可以知道客户端的电脑是否连接团队wifi了*/

        //1.先获取考勤日时间(用于判断同一天是否重复打卡)，考勤日精确到YY:MM:DD
        Date sqlDate = null;
        try {
            //1.先获取考勤日时间(用于判断同一天是否重复打卡)，考勤日精确到yyyy:MM:dd
            sqlDate = DateUtil.getDate("yyyy:MM:dd");
            System.out.println(sqlDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //2.如果通过考勤日搜索下班打卡，如果字段不为空，那么说明还没有下班打卡，那么获取打卡时间进行打卡
        Card cardCheck = cardDao.checkPunchIn(sqlDate,card.getCardUserId());
        System.out.println(cardCheck);
        //还没有上班打卡
        if(cardCheck==null) {
            return Result.error("今天还没进行上班打卡哟，无法下班打卡!");
        }
        else if(cardCheck.getCardTimeEnd()==null) {
            cardCheck.setCardTimeEnd(DateUtil.getTimestamp());
            cardCheck.setCardDuration(DateUtil.getTimeDuration(cardCheck.getCardTimeBegin(),cardCheck.getCardTimeEnd()));
            cardDao.punchOut(cardCheck);
            return Result.ok("下班打个成功",card);
        }
        //3.如果已经下班打卡过了，返回fail
        else {
            return Result.error("您今天下班打过卡了哟!");
        }
    }

    @Override
    public Result searchCardByUserRealName(String userRealName, Date beginTime, Date endTime) {

        User user = userDao.searchByUserRealName(userRealName);
        if(user!=null) {
            //1.获取card_user_id;
            int userId = user.getUserId();
            List<Card> cards = cardDao.searchCardByUserId(userId, beginTime, endTime);
            return Result.ok("查询成功",cards);
        }
        else {
            return Result.error("用户不存在");
        }
    }

    @Override
    public Result searchDurationByUserRealName(String userRealName, Date beginTime, Date endTime) {
        User user = userDao.searchByUserRealName(userRealName);
        if(user!=null) {
            //1.获取card_user_id;
            int userId = user.getUserId();
            System.out.println(userId+" "+beginTime+" "+endTime);
            List<CardEo> cardEoList = cardDao.searchDurationByUserId(userId, beginTime, endTime);

            List<CardDto> cardDtoList = new ArrayList<>();

            CardDto cardDto = new CardDto();
            cardDto.setCardEOLists(cardEoList);
            cardDto.setUserRealName(userRealName);

            cardDtoList.add(cardDto);
            return Result.ok("查询成功",cardDtoList);
        }
        else {
            return Result.error("用户不存在");
        }
    }

    @Override
    public Result searchDurationByTeamName(String teamName, Date beginTime, Date endTime) {
          //先查询整个团队的成员有哪些
        Team team = teamDao.searchTeamByName(teamName);
        int teamId = team.getTeamId();
        List<User> users = userDao.searchByUserTeamId(teamId);
        List<CardDto> cardDtoList = new ArrayList<>();
        for (User user : users) {
            List<CardEo> cardEoList = cardDao.searchDurationByUserId(user.getUserId(), beginTime, endTime);

            CardDto cardDto = new CardDto();
            cardDto.setCardEOLists(cardEoList);
            cardDto.setUserRealName(user.getUserRealName());
            cardDtoList.add(cardDto);
        }
        return Result.ok("查询成功",cardDtoList);
    }

    @Override
    public Result searchCardByUserId(Integer userId, Date beginTime, Date endTime) {
        List<Card> cards = cardDao.searchCardByUserId(userId, beginTime, endTime);
        return Result.ok("查询成功",cards);
    }
}
