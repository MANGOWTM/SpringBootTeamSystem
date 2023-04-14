package com.wtmc.springbootteamsystem.controller;

import com.wtmc.springbootteamsystem.entity.Vo.Comment;
import com.wtmc.springbootteamsystem.service.CommentService;
import com.wtmc.springbootteamsystem.util.DateUtil;
import com.wtmc.springbootteamsystem.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 博客评论接口
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Resource
    private CommentService service;
    //给博客添加评论
    @PostMapping("/addComment")
    public Result addComment(@RequestBody Comment comment) {
        //给评论设置评论时间
        comment.setCommentCreateDate(DateUtil.getTimestamp());
        return service.addComment(comment);
    }

    //删除某条博客评论(用户只能删除自己的评论内容)
    @DeleteMapping("/deleteComment")
    public Result deleteComment(@RequestParam("commentId") int commentId) {
        return service.deleteComment(commentId);
    }
}
