package com.paranoidal97.ProductstMicroservice.model.dto;

import com.paranoidal97.ProductstMicroservice.model.enums.ProductType;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestProductDto {
    private String name;
    private BigDecimal price;
    private ProductType type;
    private int ammount;
    private String processor;
    private int ram;
    private String color;
    private int batteryCapacity;
    private String accesories;
}
