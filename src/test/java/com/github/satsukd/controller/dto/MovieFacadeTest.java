package com.github.satsukd.controller.dto;

import com.github.satsukd.entity.Movie;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieFacadeTest {
    private Movie movie;
    private MovieDTO movieDTO;

    @Before
    public void setUp()  {
        movie = new Movie();
        movie.setId(1);
        movie.setNameRussian("Джанго");
        movie.setNameNative("Django");
        movie.setDescription("Длинное описание ...");
        movie.setPrice(15.15);
        movie.setRating(8.6);
        movie.setYearOfRelease(2012);
        movie.setPicturePath("some_path");
        movieDTO = new MovieDTO(movie);
    }

    @Test
    public void getId() {
        assertEquals(movieDTO.getId(), movie.getId());
    }

    @Test
    public void getNameRussian() {
        assertEquals(movieDTO.getNameRussian(), movie.getNameRussian());    }

    @Test
    public void getNameNative() {
        assertEquals(movieDTO.getNameNative(), movie.getNameNative());
    }

    @Test
    public void getYearOfRelease() {
        assertEquals(Integer.parseInt(movieDTO.getYearOfRelease()), movie.getYearOfRelease());
    }

    @Test
    public void getRating() {
        assertEquals(movieDTO.getRating(), movie.getRating(), 0.00001);
    }

    @Test
    public void getPrice() {
        assertEquals(movieDTO.getPrice(), movie.getPrice(), 0.00001);
    }

    @Test
    public void getPicturePath() {
        assertEquals(movieDTO.getPicturePath(), movie.getPicturePath());
    }
}