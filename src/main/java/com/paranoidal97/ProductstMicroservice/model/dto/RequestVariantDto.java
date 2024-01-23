package com.paranoidal97.ProductstMicroservice.model.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class RequestVariantDto {
    private final BigDecimal additionalPrice;
    private final int stock;
    private final String processor;
    private final int ram;
    private final String color;
    private final int batteryCapacity;
    private final String accessories;
}
