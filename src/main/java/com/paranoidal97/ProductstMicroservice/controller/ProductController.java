package com.paranoidal97.ProductstMicroservice.controller;

import com.paranoidal97.ProductstMicroservice.model.dto.RequestProductDto;
import com.paranoidal97.ProductstMicroservice.model.dto.ResponseAllProductsDto;
import com.paranoidal97.ProductstMicroservice.model.dto.ResponseProductDto;
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
    public List<? extends ResponseAllProductsDto> getAllProducts(@RequestParam(required = false) ProductType productType) {
        if (productType != null) {
            return service.getAllByType(productType);
        } else {
            return service.getAllProducts();
        }
    }

    @GetMapping("/id/{id}")
    public ResponseProductDto getProductById(@PathVariable String id) {
        return service.getProductById(id);
    }

    @GetMapping("/{id}/{variantId}")
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

    @PutMapping("/editeProductById/{id}")
    public ResponseProductDto editeProductById(@PathVariable String id) {
        return service.editProductById(id);
    }

    @PutMapping("/addVariant/{id}")
    public ResponseProductDto addVariant(@RequestBody RequestProductDto variant, @PathVariable String id) {
        return service.addVariant(variant, id);
    }

    //TODO usuwania wairnatu
}
