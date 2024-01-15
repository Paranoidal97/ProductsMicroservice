package com.paranoidal97.ProductstMicroservice.model.dto;

import com.paranoidal97.ProductstMicroservice.model.entity.Product;
import com.paranoidal97.ProductstMicroservice.model.enums.ProductType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@ToString
public class ResponseProductDto {
    private String id;
    private String name;
    private BigDecimal price;
    private ProductType type;
    private String processor;
    private int ram;
    private String color;
    private int batteryCapacity;
    private String accesories;
    private List<Product> variants;
}
