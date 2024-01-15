package com.paranoidal97.ProductstMicroservice.model.entity;

import com.paranoidal97.ProductstMicroservice.model.enums.ProductType;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString
@Document(collection = "products")
public class Product {
    @Id
    private String id;
    private String name;
    private BigDecimal price;
    private int ammount;
    private ProductType type;
    private List<Product> variants;
}
