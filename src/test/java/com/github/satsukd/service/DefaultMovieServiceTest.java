package com.github.satsukd.service;

import com.github.satsukd.dao.MovieDao;
import com.github.satsukd.dataprovider.MovieData;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DefaultMovieServiceTest {

    private MovieDao movieDao;

    @Before
    public void setUp() {
        movieDao = mock(MovieDao.class);
    }

    @Test
    public void getAll() {
        when(movieDao.getAll()).thenReturn(MovieData.getMovieList());
        MovieService movieService = new DefaultMovieService(movieDao);
        assertEquals(2, movieService.getAll().size());
        assertEquals(MovieData.getMovieList(), movieService.getAll());
    }
}