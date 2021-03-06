package com.github.satsukd.dao.jdbc;

import com.github.satsukd.dao.GenreDao;
import com.github.satsukd.dao.mapper.GenreRowMapper;
import com.github.satsukd.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcGenreDao implements GenreDao {
    private static final GenreRowMapper GENRE_ROW_MAPPER = new GenreRowMapper();


    private String sqlGetAllGenres;
    private String sqlGetGenresByMovieId;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcGenreDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setSqlGetAllGenres(@Value("${query.genre.sqlGetAllGenres}") String sqlGetAllGenres) {
        this.sqlGetAllGenres = sqlGetAllGenres;
    }

    @Autowired
    public void setSqlGetGenresByMovieId(@Value("${query.genre.sqlGetGenresByMovieId}") String sqlGetGenresByMovieId) {
        this.sqlGetGenresByMovieId = sqlGetGenresByMovieId;
    }

    @Override
    public List<Genre> getAll() {
        return jdbcTemplate.query(sqlGetAllGenres, GENRE_ROW_MAPPER);
    }

    @Override
    public List<Genre> getByMovieId(long movieId) {
        return jdbcTemplate.query(sqlGetGenresByMovieId, GENRE_ROW_MAPPER, movieId);
    }
}
