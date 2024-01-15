package com.paranoidal97.ProductstMicroservice.service;

import com.paranoidal97.ProductstMicroservice.model.dto.RequestProductDto;
import com.paranoidal97.ProductstMicroservice.model.dto.ResponseAllProductDto;
import com.paranoidal97.ProductstMicroservice.model.dto.ResponseProductDto;
import com.paranoidal97.ProductstMicroservice.model.enums.ProductType;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public List<ResponseAllProductDto> getAllProducts() ;

    public List<ResponseProductDto> getAllByType(ProductType productType);
    public ResponseProductDto getProductById(String id);

    public void deleteProductById(String id);

    public ResponseProductDto editeProductById(String id);

    public ResponseProductDto addVariant(RequestProductDto variant, String id);

    ResponseProductDto getProductWithVariant(String id, String variantId);

    Optional<ResponseProductDto> createProduct(RequestProductDto requestProductDto);
}
