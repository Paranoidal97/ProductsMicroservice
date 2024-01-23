package com.paranoidal97.ProductstMicroservice.service.impl;

import com.paranoidal97.ProductstMicroservice.exception.DataNotFoundException;
import com.paranoidal97.ProductstMicroservice.mapper.ConfigurationMapper;
import com.paranoidal97.ProductstMicroservice.mapper.ProductMapper;
import com.paranoidal97.ProductstMicroservice.model.configuration.ComputerConfiguration;
import com.paranoidal97.ProductstMicroservice.model.configuration.SmartphoneConfiguration;
import com.paranoidal97.ProductstMicroservice.model.dto.RequestProductDto;
import com.paranoidal97.ProductstMicroservice.model.dto.RequestVariantDto;
import com.paranoidal97.ProductstMicroservice.model.dto.ResponseProductDto;
import com.paranoidal97.ProductstMicroservice.model.dto.ResponseProductsDto;
import com.paranoidal97.ProductstMicroservice.model.entity.Product;
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
    private final ConfigurationMapper configurationMapper;

    @Override
    public List<ResponseProductsDto> getAllProducts() {
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
        log.info("Product to create: {}", requestProductDto.toString());

        Product product = productMapper.toEntity(requestProductDto);
        productRepository.save(product);
        log.info("Created product: {}", product.toString());
        return productMapper.toResponseProductDto(product);
    }

    @Override
    public void deleteVariantById(String id, String configurationId) {
        Product productById = productRepository.findById(id)
                .orElseThrow(
                        () -> new DataNotFoundException("there is no such product")
                );
        if(!productById.getVariants().stream().anyMatch(variant -> variant.getConfigurationId().equals(configurationId))){
            throw new DataNotFoundException("there is no such variant");
        }
        productRepository.deleteVariantByConfigurationId(id, configurationId);
    }

    public ResponseProductDto addVariant(RequestVariantDto variant, String id) {
        log.info("Variant to add: {}", variant.toString());
        Product productById = productRepository.findById(id)
                .orElseThrow(
                        () -> new DataNotFoundException("there is no such product")
                );
        if (productById.getVariants() == null) {
            productById.setVariants(new ArrayList<>());
        }
        if (productById.getType().equals(ProductType.SMARTPHONE)) {
            String variantId = UUID.randomUUID().toString();
            SmartphoneConfiguration smartphoneConfiguration = configurationMapper.toSmartphoneConfiguration(variant);
            smartphoneConfiguration.setConfigurationId(variantId);
            productById.getVariants().add(smartphoneConfiguration);
        } else if (productById.getType().equals(ProductType.PC)) {
            String variantId = UUID.randomUUID().toString();
            ComputerConfiguration computerConfiguration = configurationMapper.toComputerConfiguration(variant);
            computerConfiguration.setConfigurationId(variantId);
            productById.getVariants().add(computerConfiguration);
        } else {
            throw new IllegalArgumentException("Electronics cant have variants");
        }
        productRepository.save(productById);
        log.info("Product with added variant: {}", productById.toString());
        return productMapper.toResponseProductDto(productById);
    }

    public ResponseProductDto getProductWithVariant(String id, String variantId) {
        Product productById = productRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("There is no such product"));

        return productMapper.toResponseProductDto(productById);
    }
}
