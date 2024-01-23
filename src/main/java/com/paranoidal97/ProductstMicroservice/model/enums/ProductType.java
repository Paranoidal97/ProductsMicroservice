package com.paranoidal97.ProductstMicroservice.model.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ProductType {
    PC("PC"),
    SMARTPHONE("SMARTPHONE"),
    ELECTRONICS("ELECTRONICS");

    private final String type;

}
