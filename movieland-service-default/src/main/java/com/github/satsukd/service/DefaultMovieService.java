package com.github.satsukd.service;

import com.github.satsukd.dao.MovieDao;
import com.github.satsukd.dto.MovieRequestParamsDto;
import com.github.satsukd.entity.Movie;
import com.github.satsukd.service.enrich.MovieEnrichService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultMovieService implements MovieService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private MovieDao movieDao;
    private MovieEnrichService movieEnrichService;

    DefaultMovieService(@Autowired MovieDao movieDao, @Autowired MovieEnrichService movieEnrichService) {
        this.movieDao = movieDao;
        this.movieEnrichService = movieEnrichService;
    }

    @Override
    public List<Movie> getAll(MovieRequestParamsDto requestParamsDto) {
        return movieDao.getAll(requestParamsDto);
    }

    @Override
    public List<Movie> getRandom() {
        return movieDao.getRandom();
    }

    @Override
    public List<Movie> getByGenreId(int genreId, MovieRequestParamsDto requestParamsDto) {
        return movieDao.getByGenreId(genreId, requestParamsDto);
    }

    @Override
    public Movie getById(int id) {
        Movie movie = movieDao.getById(id);
        movieEnrichService.enrich(movie);
        return movie;
    }

}