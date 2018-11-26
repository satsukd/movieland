package com.github.satsukd.service;

import com.github.satsukd.dao.MovieDao;
import com.github.satsukd.entity.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultMovieService implements MovieService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private MovieDao movieDao;

    DefaultMovieService(@Autowired MovieDao movieDao) {
        log.debug("DefaultMovieService constructor called with MovieDao {}", MovieDao.class);
        this.movieDao = movieDao;
    }

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }

    @Override
    public List<Movie> getRandom() {
        return movieDao.getRandom();
    }
}