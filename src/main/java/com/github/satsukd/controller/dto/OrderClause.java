package com.github.satsukd.controller.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum OrderClause {
    ASC("ASC"),
    DESC("DESC");

    private String clause;

    public static OrderClause getOrderClause(String clause) {
        return OrderClause.valueOf(clause.trim().toUpperCase());
    }
}
