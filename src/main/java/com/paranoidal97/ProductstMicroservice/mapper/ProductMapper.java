package com.paranoidal97.ProductstMicroservice.mapper;

import com.paranoidal97.ProductstMicroservice.model.dto.RequestProductDto;
import com.paranoidal97.ProductstMicroservice.model.dto.ResponseProductDto;
import com.paranoidal97.ProductstMicroservice.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.context.annotation.Primary;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        componentModel = "spring"
)
public interface ProductMapper {

    ResponseProductDto toResponseProductDto(Product product);
    Product toEntity(RequestProductDto requestProductDto);
}
