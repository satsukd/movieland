package com.github.satsukd.service;

import com.github.satsukd.dao.MovieDao;
import com.github.satsukd.dataprovider.MovieData;
import com.github.satsukd.service.enrich.MovieEnrichService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DefaultMovieServiceTest {

    private MovieDao movieDao;
    private MovieEnrichService movieEnrichService;

    @Before
    public void setUp() {
        movieDao = mock(MovieDao.class);
        movieEnrichService = mock(MovieEnrichService.class);
    }

    @Test
    public void testGetAll() {
        when(movieDao.getAll(any())).thenReturn(MovieData.getMovieList());
        MovieService movieService = new DefaultMovieService(movieDao, movieEnrichService);
        assertEquals(3, movieService.getAll(any()).size());
        assertEquals(MovieData.getMovieList(), movieService.getAll(any()));
    }

    @Test
    public void testGetRandom() {
        when(movieDao.getRandom()).thenReturn(MovieData.getMovieRandomList());
        MovieService movieService = new DefaultMovieService(movieDao,movieEnrichService);
        assertEquals(1, movieService.getRandom().size());
    }

    @Test
    public void testGetMovieByGenreId() {
        when(movieDao.getByGenreId(anyInt(), any())).thenReturn(MovieData.getMovieList());
        MovieService movieService = new DefaultMovieService(movieDao,movieEnrichService);
        assertEquals(3, movieService.getByGenreId(anyInt(),any()).size());
        assertEquals(MovieData.getMovieList(), movieService.getByGenreId(anyInt(),any()));
    }
}