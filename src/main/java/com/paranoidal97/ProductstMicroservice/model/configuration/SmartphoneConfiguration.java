package com.paranoidal97.ProductstMicroservice.model.configuration;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class SmartphoneConfiguration extends BaseConfiguration {
    private String color;
    private int batteryCapacity;
    private String accessories;
}
