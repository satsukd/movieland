package com.github.satsukd.controller.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class MovieRequestParamsDto {
    private String rating;
    private String price;
    private Map<FiledNames, OrderClause> orderedFields = new HashMap<>();

    public void addOrderClause(FiledNames filedName, OrderClause orderClause) {
        orderedFields.put(filedName, orderClause);
    }

}