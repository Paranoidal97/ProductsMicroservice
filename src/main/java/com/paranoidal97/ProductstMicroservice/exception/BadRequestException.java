package com.paranoidal97.ProductstMicroservice.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends ProductException {

    public BadRequestException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
