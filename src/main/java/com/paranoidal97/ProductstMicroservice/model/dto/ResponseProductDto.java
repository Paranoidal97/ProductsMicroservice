package com.paranoidal97.ProductstMicroservice.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.paranoidal97.ProductstMicroservice.model.configuration.BaseConfiguration;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class ResponseProductDto extends ResponseProductsDto {
    @JsonInclude(Include.NON_NULL)
    private final String processor;
    @JsonInclude(Include.NON_DEFAULT)
    private final int ram;
    @JsonInclude(Include.NON_NULL)
    private final String color;
    @JsonInclude(Include.NON_DEFAULT)
    private final int batteryCapacity;
    @JsonInclude(Include.NON_NULL)
    private final String accessories;
    @JsonInclude(Include.NON_EMPTY)
    private final List<BaseConfiguration> variants;
}
