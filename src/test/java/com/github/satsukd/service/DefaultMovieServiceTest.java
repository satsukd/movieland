package com.github.satsukd.service;

import com.github.satsukd.dao.MovieDao;
import com.github.satsukd.dataprovider.MovieData;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DefaultMovieServiceTest {

    private MovieDao movieDao;

    @Before
    public void setUp() {
        movieDao = mock(MovieDao.class);
    }

    @Test
    public void testGetAll() {
        when(movieDao.getAll(any())).thenReturn(MovieData.getMovieList());
        MovieService movieService = new DefaultMovieService(movieDao);
        assertEquals(3, movieService.getAll(any()).size());
        assertEquals(MovieData.getMovieList(), movieService.getAll(any()));
    }

    @Test
    public void testGetRandom() {
        when(movieDao.getRandom()).thenReturn(MovieData.getMovieRandomList());
        MovieService movieService = new DefaultMovieService(movieDao);
        assertEquals(1, movieService.getRandom().size());
    }

    @Test
    public void testGetMovieByGenreId() {
        when(movieDao.getByGenreId(anyInt(), any())).thenReturn(MovieData.getMovieList());
        MovieService movieService = new DefaultMovieService(movieDao);
        assertEquals(3, movieService.getByGenreId(anyInt(),any()).size());
        assertEquals(MovieData.getMovieList(), movieService.getByGenreId(anyInt(),any()));
    }
}