package com.paranoidal97.ProductstMicroservice.exception;

import org.springframework.http.HttpStatus;

public class DataNotFoundException extends ProductException {
    public DataNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
