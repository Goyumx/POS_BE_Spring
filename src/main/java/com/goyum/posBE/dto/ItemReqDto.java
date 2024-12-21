package com.goyum.posBE.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemReqDto {

    private String name;
    private Double price;
    private int qty;
    private String description;
    private Long categoryId;
    private List<Long> stockIds;

}
