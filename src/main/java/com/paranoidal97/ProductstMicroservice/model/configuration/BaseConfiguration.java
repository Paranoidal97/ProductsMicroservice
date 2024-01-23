package com.paranoidal97.ProductstMicroservice.model.configuration;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@SuperBuilder
@NoArgsConstructor
public class BaseConfiguration {
    private String configurationId;
    private BigDecimal additionalPrice;
    private int stock;
}
