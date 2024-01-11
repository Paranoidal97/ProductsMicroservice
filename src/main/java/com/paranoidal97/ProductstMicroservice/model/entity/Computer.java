package com.paranoidal97.ProductstMicroservice.model.entity;

import com.paranoidal97.ProductstMicroservice.model.enums.ProductType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
@DiscriminatorValue(value= ProductType.Values.PC)
public class Computer extends Product{
    private String processor;
    private int ram;
}
