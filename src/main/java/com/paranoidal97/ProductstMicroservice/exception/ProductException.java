package com.paranoidal97.ProductstMicroservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public abstract class ProductException extends RuntimeException {
    private final HttpStatus status;

    public ProductException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
