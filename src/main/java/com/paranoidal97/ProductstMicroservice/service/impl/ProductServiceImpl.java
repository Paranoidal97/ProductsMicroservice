package com.paranoidal97.ProductstMicroservice.service.impl;

import com.paranoidal97.ProductstMicroservice.exception.BadRequestException;
import com.paranoidal97.ProductstMicroservice.exception.DataNotFoundException;
import com.paranoidal97.ProductstMicroservice.mapper.ComputerMapper;
import com.paranoidal97.ProductstMicroservice.mapper.ProductMapper;
import com.paranoidal97.ProductstMicroservice.mapper.SmartphoneMapper;
import com.paranoidal97.ProductstMicroservice.model.dto.RequestProductDto;
import com.paranoidal97.ProductstMicroservice.model.dto.ResponseAllProductsDto;
import com.paranoidal97.ProductstMicroservice.model.dto.ResponseProductDto;
import com.paranoidal97.ProductstMicroservice.model.entity.Computer;
import com.paranoidal97.ProductstMicroservice.model.entity.Product;
import com.paranoidal97.ProductstMicroservice.model.entity.Smartphone;
import com.paranoidal97.ProductstMicroservice.model.enums.ProductType;
import com.paranoidal97.ProductstMicroservice.repository.ProductRepository;
import com.paranoidal97.ProductstMicroservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ComputerMapper computerMapper;
    private final SmartphoneMapper smartphoneMapper;

    @Override
    public List<ResponseAllProductsDto> getAllProducts() {
        List<Product> allProducts = productRepository.findAll();
        return allProducts.stream()
                .map(productMapper::toResponseAllProductDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ResponseProductDto> getAllByType(ProductType productType) {
        List<Product> allByType = productRepository.findAllByType(productType);
        return allByType.stream()
                .map(productMapper::toResponseProductDto)
                .collect(Collectors.toList());

    }

    @Override
    public ResponseProductDto getProductById(String id) {
        Product ProductById = productRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("There is no such product"));
        return productMapper.toResponseProductDto(ProductById);
    }

    @Override
    public void deleteProductById(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public ResponseProductDto editProductById(String id) {
        Product ProductById = productRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("There is no such product"));
        return productMapper.toResponseProductDto(ProductById); //TODO dodaj edycje
    }

    @Override
    public ResponseProductDto createProduct(RequestProductDto requestProductDto) {
        System.out.println(requestProductDto);
        if (ProductType.PC.equals(requestProductDto.getType())) {
            Computer computer = computerMapper.toEntity(requestProductDto);
            productRepository.save(computer);
            return computerMapper.toResponseProductDto(computer);
        } else if (ProductType.SMARTPHONE.equals(requestProductDto.getType())) {
            Smartphone smartphone = smartphoneMapper.toEntity(requestProductDto);
            productRepository.save(smartphone);
            return smartphoneMapper.toResponseProductDto(smartphone);
        } else if (ProductType.ELECTRONICS.equals(requestProductDto.getType())) {
            Product product = productMapper.toEntity(requestProductDto);
            productRepository.save(product);
            return productMapper.toResponseProductDto(product);
        } else {
            throw new BadRequestException("Bad type");
        }
    }

    public ResponseProductDto addVariant(RequestProductDto variant, String id) {
        Product productById = productRepository.findById(id)
                .orElseThrow(
                        () -> new DataNotFoundException("there is no such product")
                );
        Product variantEntity = productMapper.toEntity(variant);
        variantEntity.setId(UUID.randomUUID().toString());
        if (productById.getVariants() == null) {
            productById.setVariants(new ArrayList<>());
        }
        if (!productById.getVariants().contains(variantEntity)) {
            productById.getVariants().add(variantEntity);
        }
        productRepository.save(productById);
        return productMapper.toResponseProductDto(productById);
    }

    public ResponseProductDto getProductWithVariant(String id, String variantId) {
        Product productById = productRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("There is no such product"));

        return productMapper.toResponseProductDto(productById);
    }
}
