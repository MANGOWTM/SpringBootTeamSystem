package com.wtmc.springbootteamsystem.entity.Dto;

import lombok.Data;

@Data
public class PageDto {
    private Integer currentPage;
    private Integer pageSize;
    private Integer total;
}
