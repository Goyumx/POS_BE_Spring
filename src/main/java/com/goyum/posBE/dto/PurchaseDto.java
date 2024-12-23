package com.goyum.posBE.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseDto {
    private List<Long> purchased_items;
}
