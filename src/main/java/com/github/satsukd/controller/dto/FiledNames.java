package com.github.satsukd.controller.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum FiledNames {
    PRICE("PRICE"),
    RATING("RATING");

    private String fieldName;

    public static FiledNames getFieldNames(String fieldName) {
        return FiledNames.valueOf(fieldName.trim().toUpperCase());
    }
}
