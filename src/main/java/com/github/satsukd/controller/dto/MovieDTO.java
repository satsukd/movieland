package com.github.satsukd.controller.dto;

import com.github.satsukd.entity.Movie;
import lombok.Getter;

@Getter
public class MovieDTO {

    private long id;
    private String nameRussian;
    private String nameNative;
    private int yearOfRelease;
    private double rating;
    private double price;
    private String picturePath;

    public MovieDTO(Movie movie) {
        this.id = movie.getId();
        this.nameRussian = movie.getNameRussian();
        this.nameNative = movie.getNameNative();
        this.yearOfRelease = movie.getYearOfRelease();
        this.rating = movie.getRating();
        this.price = movie.getPrice();
        this.picturePath = movie.getPicturePath();
    }

    public String getYearOfRelease() {
        return Integer.toString(yearOfRelease);
    }
}
