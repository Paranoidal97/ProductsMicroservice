package com.paranoidal97.ProductstMicroservice.model.dto;

import com.paranoidal97.ProductstMicroservice.model.enums.ProductType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor
@ToString
public class ResponseProductDto {
    private long id;
    private String name;
    private BigDecimal price;
    private ProductType type;
    private String processor;
    private int ram;
    private String color;
    private int batteryCapacity;
    private String accesories;
}
