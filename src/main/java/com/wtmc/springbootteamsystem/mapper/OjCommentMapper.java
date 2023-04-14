package com.wtmc.springbootteamsystem.mapper;

import com.wtmc.springbootteamsystem.entity.Vo.OjComment;

import java.util.List;

public interface OjCommentMapper {
    public void addComment(OjComment comment);
    public void deleteComment(OjComment comment);
    public List<OjComment> searchOjComment(int id);
}
