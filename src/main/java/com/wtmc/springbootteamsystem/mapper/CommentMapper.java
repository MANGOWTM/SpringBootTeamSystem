package com.wtmc.springbootteamsystem.mapper;

import com.wtmc.springbootteamsystem.entity.Comment;
import com.wtmc.springbootteamsystem.util.Result;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface CommentMapper {
    //给博客添加评论
    public void addComment(Comment comment);

    //删除某条博客评论
    public void deleteComment(int commentId);
}
