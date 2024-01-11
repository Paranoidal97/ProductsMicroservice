package com.paranoidal97.ProductstMicroservice.mapper;

import com.paranoidal97.ProductstMicroservice.model.dto.RequestProductDto;
import com.paranoidal97.ProductstMicroservice.model.dto.ResponseProductDto;
import com.paranoidal97.ProductstMicroservice.model.entity.Product;
import com.paranoidal97.ProductstMicroservice.model.entity.Smartphone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        componentModel = "spring")
public interface SmartphoneMapper{

    ResponseProductDto toResponseProductDto(Smartphone smartphone);

    Smartphone toEntity(RequestProductDto requestProductDto);
}
