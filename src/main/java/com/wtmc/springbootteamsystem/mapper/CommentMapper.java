package com.wtmc.springbootteamsystem.mapper;

import com.wtmc.springbootteamsystem.entity.Vo.Comment;

public interface CommentMapper {
    //给博客添加评论
    public void addComment(Comment comment);

    //删除某条博客评论
    public void deleteComment(int commentId);
}
