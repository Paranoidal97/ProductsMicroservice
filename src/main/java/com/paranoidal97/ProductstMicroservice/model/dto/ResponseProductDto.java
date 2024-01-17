package com.paranoidal97.ProductstMicroservice.model.dto;

import com.paranoidal97.ProductstMicroservice.model.entity.Product;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
public class ResponseProductDto extends ResponseAllProductsDto {
    private final String processor;
    private final int ram;
    private final String color;
    private final int batteryCapacity;
    private final String accesories;
    private final List<Product> variants;
}
