package com.github.satsukd.controller.facade.entity;

import com.github.satsukd.entity.Movie;

public class MovieFacade {

    private Movie movie;

    private long id;
    private String nameRussian;
    private String nameNative;
    private int yearOfRelease;
    private double rating;
    private double price;
    private String picturePath;

    public MovieFacade(Movie movie) {
        this.movie = movie;
    }

    public long getId() {
        return movie.getId();
    }

    public String getNameRussian() {
        return movie.getNameRussian();
    }

    public String getNameNative() {
        return movie.getNameNative();
    }

    public String getYearOfRelease() {
        return Integer.toString(movie.getYearOfRelease());
    }

    public double getRating() {
        return movie.getRating();
    }

    public double getPrice() {
        return movie.getPrice();
    }

    public String getPicturePath() {
        return movie.getPicturePath();
    }
}
