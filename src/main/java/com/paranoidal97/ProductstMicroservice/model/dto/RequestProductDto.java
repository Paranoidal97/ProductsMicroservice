package com.paranoidal97.ProductstMicroservice.model.dto;

import com.paranoidal97.ProductstMicroservice.model.enums.ProductType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class RequestProductDto {
    private final String name;
    private final BigDecimal price;
    private final ProductType type;
    private final int ammount;
    private final String processor;
    private final int ram;
    private final String color;
    private final int batteryCapacity;
    private final String accesories;
}
