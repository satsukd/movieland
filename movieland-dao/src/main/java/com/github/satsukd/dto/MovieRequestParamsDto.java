package com.github.satsukd.dto;

import lombok.Data;

import java.util.EnumMap;
import java.util.Map;

@Data
public class MovieRequestParamsDto {
    private String rating;
    private String price;
    private Map<FiledNames, OrderClause> orderedFields = new EnumMap<>(FiledNames.class);

    public void addOrderClause(FiledNames filedName, OrderClause orderClause) {
        orderedFields.put(filedName, orderClause);
    }
}