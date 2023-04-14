package com.wtmc.springbootteamsystem.controller;

import com.wtmc.springbootteamsystem.entity.Vo.OjComment;
import com.wtmc.springbootteamsystem.service.OjCommentService;
import com.wtmc.springbootteamsystem.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * OJ解题评论接口
 */
@RestController
@RequestMapping("/ojComment")
public class OjCommentController {
    @Resource
    private OjCommentService service;


    //OJ解题评论添加(用户可以对这份AC的代码进行评论，每一条评论包含的内容(评论用户的姓名，评论内容，评论时间))
    @PostMapping("/addOjComment")
    public Result addOjComment(@RequestBody OjComment comment) {
        return service.addOjComment(comment);
    }

    //OJ解题评论删除(用户只能删除自己的评论内容)
    @DeleteMapping("/deleteOjComment")
    public Result deleteOjComment(@RequestBody OjComment comment) {
        return service.deleteOjComment(comment);
    }

    //查询一个OC题解的所有评论
    @GetMapping("/searchOjComment")
    public Result searchOjComment(@RequestParam("ojCommentSolveId") int id){
        return service.searchOjComment(id);
    }
}
