package com.wtmc.springbootteamsystem.entity.Dto;

import com.wtmc.springbootteamsystem.entity.Eo.CardEo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDto {
    private List<CardEo> cardEOLists;
    private String userRealName;
}
