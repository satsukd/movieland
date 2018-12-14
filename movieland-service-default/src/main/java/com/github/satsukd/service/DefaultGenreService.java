package com.github.satsukd.service;

import com.github.satsukd.dao.GenreDao;
import com.github.satsukd.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultGenreService implements GenreService {

    private GenreDao genreDao;

    public DefaultGenreService(@Autowired GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    @Override
    public List<Genre> getAll() {
        return genreDao.getAll();
    }

    @Override
    public List<Genre> getByMovieId(int movieId) {
        return genreDao.getByMovieId(movieId);
    }
}