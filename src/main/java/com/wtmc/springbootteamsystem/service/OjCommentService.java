package com.wtmc.springbootteamsystem.service;

import com.wtmc.springbootteamsystem.entity.OjComment;
import com.wtmc.springbootteamsystem.util.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface OjCommentService {
    //OJ解题评论添加(用户可以对这份AC的代码进行评论，每一条评论包含的内容(评论用户的姓名，评论内容，评论时间))
    public Result addOjComment(OjComment comment);

    //OJ解题评论删除(用户只能删除自己的评论内容)
    public Result deleteOjComment(OjComment comment);
}
