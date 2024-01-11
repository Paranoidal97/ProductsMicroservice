package com.paranoidal97.ProductstMicroservice.repository;

import com.paranoidal97.ProductstMicroservice.model.entity.Product;
import com.paranoidal97.ProductstMicroservice.model.enums.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByType(ProductType type);
}
