package com.github.satsukd.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MovieDTO {

    private long id;
    private String nameRussian;
    private String nameNative;
    private int yearOfRelease;
    private double rating;
    private double price;
    private String picturePath;

    public String getYearOfRelease() {
        return Integer.toString(yearOfRelease);
    }
}
