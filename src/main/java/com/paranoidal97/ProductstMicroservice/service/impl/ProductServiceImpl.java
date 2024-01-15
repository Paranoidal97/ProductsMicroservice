package com.paranoidal97.ProductstMicroservice.service.impl;

import com.paranoidal97.ProductstMicroservice.exception.BadRequestException;
import com.paranoidal97.ProductstMicroservice.exception.DataNotFoundException;
import com.paranoidal97.ProductstMicroservice.mapper.ComputerMapper;
import com.paranoidal97.ProductstMicroservice.mapper.ProductMapper;
import com.paranoidal97.ProductstMicroservice.mapper.SmartphoneMapper;
import com.paranoidal97.ProductstMicroservice.model.dto.RequestProductDto;
import com.paranoidal97.ProductstMicroservice.model.dto.ResponseAllProductDto;
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
import java.util.Optional;
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
    public List<ResponseAllProductDto> getAllProducts() {
        List<Product> allProducts = productRepository.findAll();
        System.out.println(allProducts);
        return allProducts.stream()
                .map(productMapper::toResponseAllProductDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ResponseProductDto> getAllByType(ProductType productType) {
        List<Product> allByType = productRepository.findAllByType(productType);
        System.out.println(allByType);
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
    public ResponseProductDto editeProductById(String id) {
        Product ProductById = productRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("There is no such product"));
        return productMapper.toResponseProductDto(ProductById); //TODO dodaj edycje
    }

    @Override
    public Optional<ResponseProductDto> createProduct(RequestProductDto requestProductDto) {
        System.out.println(requestProductDto);
            if (ProductType.Values.PC.equals(requestProductDto.getType().toString())) {
                Computer computer = computerMapper.toEntity(requestProductDto);
                System.out.println(computer);
                productRepository.save(computer);
                return Optional.ofNullable(computerMapper.toResponseProductDto(computer));
            }
            else if (ProductType.Values.SMARTPHONE.equals(requestProductDto.getType().toString())) {
                Smartphone smartphone = smartphoneMapper.toEntity(requestProductDto);
                System.out.println(smartphone);
                productRepository.save(smartphone);
                return Optional.ofNullable(smartphoneMapper.toResponseProductDto(smartphone));
            }
            else if(ProductType.Values.ELECTRONICS.equals(requestProductDto.getType().toString())){
                Product product = productMapper.toEntity(requestProductDto);
                System.out.println(product.toString());
                productRepository.save(product);
                return Optional.ofNullable(productMapper.toResponseProductDto(product));
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
        if(productById.getVariants() == null){
            productById.setVariants(new ArrayList<>());
        }
        if (!productById.getVariants().contains(variantEntity)) {
            productById.getVariants().add(variantEntity);
        }
        productRepository.save(productById);
        return productMapper.toResponseProductDto(productById);
    }

    public ResponseProductDto getProductWithVariant(String id, String variantId) {
        Product ProductById = productRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("There is no such product"));

        return productMapper.toResponseProductDto(ProductById);
    }
}
