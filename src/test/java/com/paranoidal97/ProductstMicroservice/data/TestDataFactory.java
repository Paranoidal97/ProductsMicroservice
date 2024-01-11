package com.paranoidal97.ProductstMicroservice.data;

import com.paranoidal97.ProductstMicroservice.model.entity.Computer;
import com.paranoidal97.ProductstMicroservice.model.entity.Product;
import com.paranoidal97.ProductstMicroservice.model.entity.Smartphone;
import com.paranoidal97.ProductstMicroservice.model.enums.ProductType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TestDataFactory {
    public static Computer createSampleComputer() {
        Computer computer1 = Computer.builder()
                .name("Komputer")
                .processor("procesor")
                .ram(8)
                .type(ProductType.PC)
                .price(BigDecimal.valueOf(10.000))
                .build();
        return computer1;
    }

    public static Product createSampleProduct() {
        Product product1 = Product.builder()
                .name("Produkt")
                .type(ProductType.ELECTRONICS)
                .price(BigDecimal.valueOf(11.000))
                .build();
        return product1;
    }

    public static Smartphone createSampleSmartphone() {
        Smartphone product1 = Smartphone.builder()
                .name("Komputer")
                .type(ProductType.SMARTPHONE)
                .price(BigDecimal.valueOf(12.000))
                .color("Black")
                .accesories("accesorieeeee")
                .batteryCapacity(3000)
                .build();
        return product1;
    }

    public static List<Product> createSampleProducts(){
        Smartphone product1 = Smartphone.builder()
                .name("Komputer")
                .type(ProductType.SMARTPHONE)
                .price(BigDecimal.valueOf(12.000))
                .color("Black")
                .accesories("accesorieeeee")
                .batteryCapacity(3000)
                .build();

        Product product2 = Product.builder()
                .name("Produkt")
                .type(ProductType.ELECTRONICS)
                .price(BigDecimal.valueOf(11.000))
                .build();

        Computer computer1 = Computer.builder()
                .name("Komputer")
                .processor("procesor")
                .ram(8)
                .type(ProductType.PC)
                .price(BigDecimal.valueOf(10.000))
                .build();

        List<Product> products= new ArrayList<>();

        products.add(product1);
        products.add(product2);
        products.add(computer1);

        return products;
    }
}
