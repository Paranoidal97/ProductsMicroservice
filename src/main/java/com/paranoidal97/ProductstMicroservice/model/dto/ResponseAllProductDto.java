package com.paranoidal97.ProductstMicroservice.model.dto;

import com.paranoidal97.ProductstMicroservice.model.enums.ProductType;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseAllProductDto {
    private String id;
    private String name;
    private BigDecimal price;
    private ProductType type;
}
