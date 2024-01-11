package com.paranoidal97.ProductstMicroservice.service;

import com.paranoidal97.ProductstMicroservice.model.dto.RequestProductDto;
import com.paranoidal97.ProductstMicroservice.model.dto.ResponseProductDto;
import com.paranoidal97.ProductstMicroservice.model.enums.ProductType;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public List<ResponseProductDto> getAllProducts() ;

    public List<ResponseProductDto> getAllByType(ProductType productType);
    public ResponseProductDto getProductById(Long id);

    public void deleteProductById(Long id);

    public ResponseProductDto editeProductById(Long id);

    Optional<ResponseProductDto> createProduct(RequestProductDto requestProductDto);
}
