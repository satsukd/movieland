package com.github.satsukd.controller.facade.entity;

import com.github.satsukd.entity.Movie;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieFacadeTest {
    private Movie movie;
    private MovieFacade movieFacade;

    @Before
    public void setUp() throws Exception {
        movie = new Movie();
        movie.setId(1);
        movie.setNameRussian("Джанго");
        movie.setNameNative("Django");
        movie.setDescription("Длинное описание ...");
        movie.setPrice(15.15);
        movie.setRating(8.6);
        movie.setYearOfRelease(2012);
        movie.setPicturePath("some_path");
        movieFacade = new MovieFacade(movie);
    }

    @Test
    public void getId() {
        assertEquals(movieFacade.getId(), movie.getId());
    }

    @Test
    public void getNameRussian() {
        assertEquals(movieFacade.getNameRussian(), movie.getNameRussian());    }

    @Test
    public void getNameNative() {
        assertEquals(movieFacade.getNameNative(), movie.getNameNative());
    }

    @Test
    public void getYearOfRelease() {
        assertEquals(Integer.parseInt(movieFacade.getYearOfRelease()), movie.getYearOfRelease());
    }

    @Test
    public void getRating() {
        assertEquals(movieFacade.getRating(), movie.getRating(), 0.00001);
    }

    @Test
    public void getPrice() {
        assertEquals(movieFacade.getPrice(), movie.getPrice(), 0.00001);
    }

    @Test
    public void getPicturePath() {
        assertEquals(movieFacade.getPicturePath(), movie.getPicturePath());
    }
}