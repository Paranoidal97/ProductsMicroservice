package com.paranoidal97.ProductstMicroservice.exception;

import org.springframework.http.HttpStatus;

public class DataAlreadyExistException extends ProductException {
    public DataAlreadyExistException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
