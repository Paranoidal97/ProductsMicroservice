package com.paranoidal97.ProductstMicroservice.model.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ProductType {
    PC(Values.PC),
    SMARTPHONE(Values.SMARTPHONE),
    ELECTRONICS(Values.ELECTRONICS);

    private String value;
    public static class Values {
        public static final String PC = "PC";
        public static final String SMARTPHONE = "SMARTPHONE";
        public static final String ELECTRONICS = "ELECTRONICS";
    }
    }
