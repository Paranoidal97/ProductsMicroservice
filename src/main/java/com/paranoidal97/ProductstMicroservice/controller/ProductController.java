package com.paranoidal97.ProductstMicroservice.controller;

import com.paranoidal97.ProductstMicroservice.model.dto.RequestProductDto;
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
    public List<ResponseProductDto> getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping("/type/{productType}")
    public List<ResponseProductDto> getAllByType(@PathVariable ProductType productType){
        System.out.println("typ");
        return service.getAllByType(productType);
    }

    @GetMapping("/id/{id}")
    public ResponseProductDto getProductById(@PathVariable Long id){
        System.out.println("tutaj");
        return service.getProductById(id);
    }

    @PostMapping
    public Optional<ResponseProductDto> createProduct(@RequestBody RequestProductDto requestProductDto){
        System.out.println(requestProductDto);
        return service.createProduct(requestProductDto);
    }

    @DeleteMapping("/id")
    public void deleteProductById(@PathVariable Long id){
        service.deleteProductById(id);
    }

    @PutMapping("/id")
    public ResponseProductDto editeProductById(@PathVariable Long id){
        return service.editeProductById(id);
    }
}
