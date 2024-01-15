package com.paranoidal97.ProductstMicroservice.mapper;

import com.paranoidal97.ProductstMicroservice.data.TestDataFactory;
import com.paranoidal97.ProductstMicroservice.model.entity.Product;
import com.paranoidal97.ProductstMicroservice.model.entity.Smartphone;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mapstruct.factory.Mappers;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartphoneMapperTest {
//    SmartphoneMapper smartphoneMapper = Mappers.getMapper(SmartphoneMapper.class);
//
//    @ParameterizedTest
//    @MethodSource("smartphoneData")
//    void SmartphoneMapperTest(Smartphone smartphone) {
//        var result = smartphoneMapper.toResponseProductDto(smartphone);
//
//        assertAll(
//                () -> assertEquals(smartphone.getPrice(),result.getPrice()),
//                () -> assertEquals(smartphone.getName(),result.getName()),
//                () -> assertEquals(smartphone.getType(),result.getType()),
//                () -> assertEquals(smartphone.getAccesories(),result.getAccesories()),
//                () -> assertEquals(smartphone.getBatteryCapacity(),result.getBatteryCapacity()),
//                () -> assertEquals(smartphone.getColor(),result.getColor())
//
//        );
//    }
//
//    public static Stream<Arguments> smartphoneData() {
//        Smartphone sampleSmartphone1 = TestDataFactory.createSampleSmartphone();
//        Smartphone sampleSmartphone2 = TestDataFactory.createSampleSmartphone();
//
//
//        return Stream.of(
//                Arguments.of(sampleSmartphone1),
//                Arguments.of(sampleSmartphone2)
//        );
//    }
}
