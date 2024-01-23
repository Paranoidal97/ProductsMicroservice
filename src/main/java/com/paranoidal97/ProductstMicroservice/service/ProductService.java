package com.paranoidal97.ProductstMicroservice.service;

import com.paranoidal97.ProductstMicroservice.model.dto.RequestProductDto;
import com.paranoidal97.ProductstMicroservice.model.dto.RequestVariantDto;
import com.paranoidal97.ProductstMicroservice.model.dto.ResponseProductDto;
import com.paranoidal97.ProductstMicroservice.model.dto.ResponseProductsDto;
import com.paranoidal97.ProductstMicroservice.model.enums.ProductType;

import java.util.List;

public interface ProductService {
    List<ResponseProductsDto> getAllProducts();

    List<ResponseProductDto> getAllByType(ProductType productType);

    ResponseProductDto getProductById(String id);

    void deleteProductById(String id);

    ResponseProductDto editProductById(String id);

    ResponseProductDto addVariant(RequestVariantDto variant, String id);

    ResponseProductDto getProductWithVariant(String id, String variantId);

    ResponseProductDto createProduct(RequestProductDto requestProductDto);

    void deleteVariantById(String id, String configurationId);
}
