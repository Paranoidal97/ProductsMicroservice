package com.paranoidal97.ProductstMicroservice.model.configuration;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class ComputerConfiguration extends BaseConfiguration {
    private String processor;
    private int ram;
}
