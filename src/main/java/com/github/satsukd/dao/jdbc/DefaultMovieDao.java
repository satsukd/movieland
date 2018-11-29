package com.github.satsukd.dao.jdbc;

import com.github.satsukd.controller.dto.FiledNames;
import com.github.satsukd.controller.dto.MovieRequestParamsDto;
import com.github.satsukd.controller.dto.OrderClause;
import com.github.satsukd.dao.MovieDao;
import com.github.satsukd.dao.mapper.MovieRowMapper;
import com.github.satsukd.entity.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

@Repository
public class DefaultMovieDao implements MovieDao {
    private static final MovieRowMapper MOVIE_ROW_MAPPER = new MovieRowMapper();
    private final Logger log = LoggerFactory.getLogger(getClass());

    private String sqlGetAllMovies;
    private String sqlGetRandomMovies;
    private String sqlGetMoviesByGenreId;
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

    @Autowired
    public void setSqlGetMoviesByGenreId(String sqlGetMoviesByGenreId) {
        this.sqlGetMoviesByGenreId = sqlGetMoviesByGenreId;
    }


    @Override
    public List<Movie> getAll(MovieRequestParamsDto requestParamsDto) {
        return jdbcTemplate.query(applyRequestParams(sqlGetAllMovies, requestParamsDto), MOVIE_ROW_MAPPER);
    }


    @Override
    public List<Movie> getRandom() {
        return jdbcTemplate.query(sqlGetRandomMovies, MOVIE_ROW_MAPPER);
    }

    @Override
    public List<Movie> getByGenreId(int genreId, MovieRequestParamsDto requestParamsDto) {
        return jdbcTemplate.query(applyRequestParams(sqlGetMoviesByGenreId, requestParamsDto), MOVIE_ROW_MAPPER, genreId);
    }

    String applyRequestParams(String query, MovieRequestParamsDto requestParamsDto) {
        StringBuilder stringBuilder = new StringBuilder(query);

        if (requestParamsDto.getOrderedFields() != null && requestParamsDto.getOrderedFields().size() != 0) {
            StringJoiner orderClause = new StringJoiner(", ", " ORDER BY ", "");

            for (Map.Entry<FiledNames, OrderClause> entry : requestParamsDto.getOrderedFields().entrySet()) {
                orderClause.add(entry.getKey() + " " + entry.getValue() + " ");
            }
            stringBuilder.append(orderClause);
        }
        log.debug("Final query is {}", stringBuilder);

        return stringBuilder.toString();
    }

}
