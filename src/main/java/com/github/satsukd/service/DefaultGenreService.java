package com.github.satsukd.service;

import com.github.satsukd.dao.GenreDao;
import com.github.satsukd.entity.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultGenreService implements GenreService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private GenreDao genreDao;

    public DefaultGenreService(@Autowired GenreDao genreDao) {
        log.debug("DefaultMovieService constructor called with GenreDao");
        this.genreDao = genreDao;
    }

    @Override
    public List<Genre> getAll() {
        return genreDao.getAll();
    }
}