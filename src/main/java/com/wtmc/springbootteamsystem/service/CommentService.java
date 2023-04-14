package com.wtmc.springbootteamsystem.service;

import com.wtmc.springbootteamsystem.entity.Vo.Comment;
import com.wtmc.springbootteamsystem.util.Result;

public interface CommentService {
    //给博客添加评论
    public Result addComment(Comment comment);


    //删除某条博客评论
    public Result deleteComment(int commentId);
}
