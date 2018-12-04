package com.github.satsukd.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Movie {
    private long id;
    private String nameRussian;
    private String nameNative;
    private String description;
    private int yearOfRelease;
    private double rating;
    private double price;
    private String picturePath;
    private LocalDateTime lastUpdateDate;
}

