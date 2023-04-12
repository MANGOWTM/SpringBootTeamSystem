package com.wtmc.springbootteamsystem.service.imp;

import com.wtmc.springbootteamsystem.entity.OjComment;
import com.wtmc.springbootteamsystem.mapper.OjCommentMapper;
import com.wtmc.springbootteamsystem.service.OjCommentService;
import com.wtmc.springbootteamsystem.util.DateUtil;
import com.wtmc.springbootteamsystem.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OjCommentServiceImpl implements OjCommentService {
    @Resource
    private OjCommentMapper dao;

    @Override
    public Result addOjComment(OjComment comment) {
        //加上评论时间
        comment.setOjCommentDate(DateUtil.getTimestamp());
        dao.addComment(comment);
        return Result.ok("Oj评论添加成功",comment);
    }

    @Override
    public Result deleteOjComment(OjComment comment) {
        dao.deleteComment(comment);
        return Result.ok("Oj评论删除成功",comment);
    }

    @Override
    public Result searchOjComment(int id) {
        List<OjComment> ojComments = dao.searchOjComment(id);
        return Result.ok("查询评论成功",ojComments);
    }
}
