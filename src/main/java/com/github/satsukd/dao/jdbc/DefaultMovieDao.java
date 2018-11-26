package com.github.satsukd.dao.jdbc;

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

    private String sqlGetAllMovies;
    private String sqlGetRandomMovies;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DefaultMovieDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setSqlGetAllMovies(String sqlGetAllMovies) {
        this.sqlGetAllMovies = sqlGetAllMovies;
    }

    @Autowired
    public void setSqlGetRandomMovies(String sqlGetRandomMovies) {
        this.sqlGetRandomMovies = sqlGetRandomMovies;
    }

    @Override
    public List<Movie> getAll() {
        return jdbcTemplate.query(sqlGetAllMovies, MOVIE_ROW_MAPPER);
    }


    @Override
    public List<Movie> getRandom() {
        return jdbcTemplate.query(sqlGetRandomMovies, MOVIE_ROW_MAPPER);
    }
}
