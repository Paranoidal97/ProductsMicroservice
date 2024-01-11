package com.paranoidal97.ProductstMicroservice.mapper;

import com.paranoidal97.ProductstMicroservice.data.TestDataFactory;
import com.paranoidal97.ProductstMicroservice.model.entity.Computer;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputerMapperTest {
    ComputerMapper computerMapper = Mappers.getMapper(ComputerMapper.class);

    @ParameterizedTest
    @MethodSource("computersData")
    void ComputerMapperTest(Computer computer) {
        var result = computerMapper.toResponseProductDto(computer);

        assertAll(
                () -> assertEquals(computer.getProcessor(),result.getProcessor()),
                () -> assertEquals(computer.getRam(),result.getRam()),
                () -> assertEquals(computer.getName(),result.getName()),
                () -> assertEquals(computer.getType(),result.getType()),
                () -> assertEquals(computer.getPrice(),result.getPrice())

        );
    }

    public static Stream<Arguments> computersData() {
        Computer sampleComputer1 = TestDataFactory.createSampleComputer();
        Computer sampleComputer2 = TestDataFactory.createSampleComputer();


        return Stream.of(
                Arguments.of(sampleComputer1),
                Arguments.of(sampleComputer2)
        );
    }
}
