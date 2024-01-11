package com.paranoidal97.ProductstMicroservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paranoidal97.ProductstMicroservice.model.enums.ProductType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"file:src/test/resources/product/insert_data.sql"},
        config = @SqlConfig(encoding = "utf-8", transactionMode = SqlConfig.TransactionMode.ISOLATED),
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = {"file:src/test/resources/product/clear_data.sql"},
        config = @SqlConfig(encoding = "utf-8", transactionMode = SqlConfig.TransactionMode.ISOLATED),
        executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class ProductControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getAllProductsTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/products"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getAllProductsByTypeTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/products/type/{productType}" , ProductType.PC))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getProductByIdTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/products/id/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void createProductTest() throws Exception{

    }

    @Test
    void deleteProductByIdTest() throws Exception{

    }

    @Test
    void editeProductByIdTest() throws Exception{

    }
}
