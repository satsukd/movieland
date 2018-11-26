package com.github.satsukd.service;

import com.github.satsukd.dao.GenreDao;
import com.github.satsukd.dataprovider.GenreData;
import com.github.satsukd.dataprovider.MovieData;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DefaultGenreServiceTest {

    @Test
    public void getAll() {
        GenreDao genreDao = mock(GenreDao.class);
        when(genreDao.getAll()).thenReturn(GenreData.getGenreList());
        GenreService genreService = new DefaultGenreService(genreDao);
        assertEquals(3, genreService.getAll().size());
        assertEquals(GenreData.getGenreList(), genreService.getAll());
    }
}