package com.paranoidal97.ProductstMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class ProductstMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductstMicroserviceApplication.class, args);
	}

}
