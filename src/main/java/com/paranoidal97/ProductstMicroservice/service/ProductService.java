package com.paranoidal97.ProductstMicroservice.service;

import com.paranoidal97.ProductstMicroservice.model.dto.RequestProductDto;
import com.paranoidal97.ProductstMicroservice.model.dto.ResponseAllProductsDto;
import com.paranoidal97.ProductstMicroservice.model.dto.ResponseProductDto;
import com.paranoidal97.ProductstMicroservice.model.enums.ProductType;

import java.util.List;

public interface ProductService {
    public List<ResponseAllProductsDto> getAllProducts();

    public List<ResponseProductDto> getAllByType(ProductType productType);

    public ResponseProductDto getProductById(String id);

    public void deleteProductById(String id);

    public ResponseProductDto editProductById(String id);

    public ResponseProductDto addVariant(RequestProductDto variant, String id);

    ResponseProductDto getProductWithVariant(String id, String variantId);

    ResponseProductDto createProduct(RequestProductDto requestProductDto);
}
