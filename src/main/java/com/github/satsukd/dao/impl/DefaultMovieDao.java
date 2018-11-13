package com.github.satsukd.dao.impl;

import com.github.satsukd.dao.MovieDao;
import com.github.satsukd.dao.mapper.MovieRowMapper;
import com.github.satsukd.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DefaultMovieDao implements MovieDao {
    private static final MovieRowMapper MOVIE_ROW_MAPPER = new MovieRowMapper();

    @Autowired
    String sqlGetAllMovies;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Movie> getAll() {
        return jdbcTemplate.query(sqlGetAllMovies, MOVIE_ROW_MAPPER);
    }
}
