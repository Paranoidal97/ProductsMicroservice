package com.paranoidal97.ProductstMicroservice.model.enums;

public enum ProductType {
    PC("PC"),
    SMARTPHONE("SMARTPHONE"),
    ELECTRONICS("ELECTRONICS");

    private String type;

    ProductType(String type) {
        this.type = type.toUpperCase();
    }
}
