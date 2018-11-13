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
    private static final String SQL_GET_ALL_MOVIES = "SELECT id, name_russian, name_native, price, rating, description, year_of_release, last_update_date, picture_path FROM movie";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Movie> getAll() {
        return jdbcTemplate.query(SQL_GET_ALL_MOVIES, MOVIE_ROW_MAPPER);
    }
}
