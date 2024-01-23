package com.paranoidal97.ProductstMicroservice.repository;

import com.paranoidal97.ProductstMicroservice.model.entity.Product;
import com.paranoidal97.ProductstMicroservice.model.enums.ProductType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findAllByType(ProductType type);

    @Query(value = "{ '_id': ?0 }", fields = "{ 'variants': { '$pull': { 'configurationId': ?1 } } }")
    void deleteVariantByConfigurationId(String productId, String configurationId);

}
