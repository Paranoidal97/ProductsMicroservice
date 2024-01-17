package com.paranoidal97.ProductstMicroservice.model.dto;

import com.paranoidal97.ProductstMicroservice.model.enums.ProductType;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@SuperBuilder
public class ResponseAllProductsDto {
    private final String id;
    private final String name;
    private final BigDecimal price;
    private final ProductType type;
}
