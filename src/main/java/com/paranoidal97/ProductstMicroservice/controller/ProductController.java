package com.paranoidal97.ProductstMicroservice.controller;

import com.paranoidal97.ProductstMicroservice.model.dto.RequestProductDto;
import com.paranoidal97.ProductstMicroservice.model.dto.RequestVariantDto;
import com.paranoidal97.ProductstMicroservice.model.dto.ResponseProductDto;
import com.paranoidal97.ProductstMicroservice.model.dto.ResponseProductsDto;
import com.paranoidal97.ProductstMicroservice.model.enums.ProductType;
import com.paranoidal97.ProductstMicroservice.service.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductServiceImpl service;

    @GetMapping
    public List<? extends ResponseProductsDto> getAllProducts(@RequestParam(required = false) ProductType productType) {
        return productType != null ? service.getAllByType(productType) : service.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseProductDto getProductById(@PathVariable String id) {
        return service.getProductById(id);
    }

    @GetMapping("/{id}/variants/{variantId}")
    public ResponseProductDto getProductWithVariant(@PathVariable String id, @PathVariable String variantId) {
        return service.getProductWithVariant(id, variantId);
    }

    @PostMapping
    public ResponseProductDto createProduct(@RequestBody RequestProductDto requestProductDto) {
        return service.createProduct(requestProductDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable String id) {
        service.deleteProductById(id);
    }

    @PutMapping("/{id}")
    public ResponseProductDto editeProductById(@PathVariable String id) {
        return service.editProductById(id);
    }

    @PostMapping("/{id}/variants")
    public ResponseProductDto addVariant(@RequestBody RequestVariantDto variant, @PathVariable String id) {
        return service.addVariant(variant, id);
    }

    @DeleteMapping("/{id}/variant/{configurationId}")
    public void deleteProductById(@PathVariable String id, @PathVariable String configurationId) {
        service.deleteVariantById(id, configurationId);
    }
    //TODO usuwania wairnatu
}
