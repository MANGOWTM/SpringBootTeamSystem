package com.wtmc.springbootteamsystem.service.imp;

import com.wtmc.springbootteamsystem.entity.Vo.Comment;
import com.wtmc.springbootteamsystem.mapper.CommentMapper;
import com.wtmc.springbootteamsystem.service.CommentService;
import com.wtmc.springbootteamsystem.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentMapper dao;

    @Override
    public Result addComment(Comment comment) {
        dao.addComment(comment);
        return Result.ok("添加博客评论成功!",comment);
    }

    @Override
    public Result deleteComment(int commentId) {
        dao.deleteComment(commentId);
        return Result.ok("博客评论删除成功!");
    }
}
