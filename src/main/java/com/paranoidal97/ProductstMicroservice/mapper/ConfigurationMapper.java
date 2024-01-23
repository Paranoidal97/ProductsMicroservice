package com.paranoidal97.ProductstMicroservice.mapper;

import com.paranoidal97.ProductstMicroservice.model.configuration.BaseConfiguration;
import com.paranoidal97.ProductstMicroservice.model.configuration.ComputerConfiguration;
import com.paranoidal97.ProductstMicroservice.model.configuration.SmartphoneConfiguration;
import com.paranoidal97.ProductstMicroservice.model.dto.RequestVariantDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        componentModel = "spring"
)
public interface ConfigurationMapper {

    BaseConfiguration toBaseConfiguration(RequestVariantDto requestVariantDto);

    ComputerConfiguration toComputerConfiguration(RequestVariantDto requestVariantDto);

    SmartphoneConfiguration toSmartphoneConfiguration(RequestVariantDto requestVariantDto);
}
