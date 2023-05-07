package com.wtmc.springbootteamsystem.entity.Param;

import com.wtmc.springbootteamsystem.entity.Dto.PageDto;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class SearchBlogParam extends PageDto {
    private String blogId;
    private String teamName;
    private String blogType;
    private String userRealName;
}
