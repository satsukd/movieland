package com.github.satsukd.dao.jdbc;

import com.github.satsukd.dao.GenreDao;
import com.github.satsukd.dao.mapper.GenreRowMapper;
import com.github.satsukd.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcGenreDao implements GenreDao {
    private static final GenreRowMapper GENRE_ROW_MAPPER = new GenreRowMapper();

    private String sqlGetAllGenres;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcGenreDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setSqlGetAllGenres(String sqlGetAllGenres) {
        this.sqlGetAllGenres = sqlGetAllGenres;
    }

    @Override
    public List<Genre> getAll() {
        return jdbcTemplate.query(sqlGetAllGenres, GENRE_ROW_MAPPER);
    }
}
