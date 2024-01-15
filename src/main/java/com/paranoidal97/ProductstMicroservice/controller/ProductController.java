package com.paranoidal97.ProductstMicroservice.controller;

import com.paranoidal97.ProductstMicroservice.model.dto.RequestProductDto;
import com.paranoidal97.ProductstMicroservice.model.dto.ResponseAllProductDto;
import com.paranoidal97.ProductstMicroservice.model.dto.ResponseProductDto;
import com.paranoidal97.ProductstMicroservice.model.enums.ProductType;
import com.paranoidal97.ProductstMicroservice.service.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductServiceImpl service;

    @GetMapping
    public List<ResponseAllProductDto> getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping("/type/{productType}")
    public List<ResponseProductDto> getAllByType(@PathVariable ProductType productType){
        System.out.println("typ");
        return service.getAllByType(productType);
    }

    @GetMapping("/id/{id}")
    public ResponseProductDto getProductById(@PathVariable String id){
        System.out.println("tutaj");
        return service.getProductById(id);
    }

    @GetMapping("/{id}/{variantId}")
    public ResponseProductDto getProductWithVariant(@PathVariable String id, @PathVariable String variantId){
        System.out.println("tutaj");
        return service.getProductWithVariant(id,variantId);
    }

    @PostMapping
    public Optional<ResponseProductDto> createProduct(@RequestBody RequestProductDto requestProductDto){
        System.out.println(requestProductDto);
        return service.createProduct(requestProductDto);
    }

    @DeleteMapping("/id")
    public void deleteProductById(@PathVariable String id){
        service.deleteProductById(id);
    }

    @PutMapping("/id")
    public ResponseProductDto editeProductById(@PathVariable String id){
        return service.editeProductById(id);
    }

    @PutMapping("/{id}")
    public ResponseProductDto addVariant(@RequestBody RequestProductDto variant, @PathVariable String id){
        return service.addVariant(variant, id);
    }

    //TODO usuwania wairnatu
}
