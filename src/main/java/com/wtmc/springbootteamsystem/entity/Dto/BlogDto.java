package com.wtmc.springbootteamsystem.entity.Dto;

import com.wtmc.springbootteamsystem.entity.Eo.CardEo;
import com.wtmc.springbootteamsystem.entity.Vo.Blog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogDto extends PageDto{
    private List<Blog> blogLists;
}
