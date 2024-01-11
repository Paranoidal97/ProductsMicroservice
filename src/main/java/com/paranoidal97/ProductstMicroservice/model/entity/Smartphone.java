package com.paranoidal97.ProductstMicroservice.model.entity;

import com.paranoidal97.ProductstMicroservice.model.enums.ProductType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue(value = ProductType.Values.SMARTPHONE)
public class Smartphone extends Product{
    private String color;
    private int batteryCapacity;
    private String accesories;
}
