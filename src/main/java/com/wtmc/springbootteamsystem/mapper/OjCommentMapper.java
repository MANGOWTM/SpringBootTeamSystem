package com.wtmc.springbootteamsystem.mapper;

import com.wtmc.springbootteamsystem.entity.Comment;
import com.wtmc.springbootteamsystem.entity.OjComment;

public interface OjCommentMapper {
    public void addComment(OjComment comment);
    public void deleteComment(OjComment comment);
}
