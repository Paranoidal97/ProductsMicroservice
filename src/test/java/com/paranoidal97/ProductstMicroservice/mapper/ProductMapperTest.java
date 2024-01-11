package com.paranoidal97.ProductstMicroservice.mapper;

import com.paranoidal97.ProductstMicroservice.data.TestDataFactory;
import com.paranoidal97.ProductstMicroservice.model.entity.Computer;
import com.paranoidal97.ProductstMicroservice.model.entity.Product;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mapstruct.factory.Mappers;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductMapperTest {
    ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

    @ParameterizedTest
    @MethodSource("productsData")
    void ComputerMapperTest(Product product) {
        var result = productMapper.toResponseProductDto(product);

        assertAll(
                () -> assertEquals(product.getPrice(),result.getPrice()),
                () -> assertEquals(product.getName(),result.getName()),
                () -> assertEquals(product.getType(),result.getType())
        );
    }

    public static Stream<Arguments> productsData() {
        Product sampleProduct1 = TestDataFactory.createSampleProduct();
        Product sampleProduct2 = TestDataFactory.createSampleProduct();


        return Stream.of(
                Arguments.of(sampleProduct1),
                Arguments.of(sampleProduct2)
        );
    }
}
