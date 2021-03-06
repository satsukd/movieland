package com.github.satsukd.dao.jdbc;

import com.github.satsukd.dto.FiledNames;
import com.github.satsukd.dto.MovieRequestParamsDto;
import com.github.satsukd.dto.OrderClause;
import com.github.satsukd.dao.MovieDao;
import com.github.satsukd.dao.mapper.MovieRowMapper;
import com.github.satsukd.entity.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

@Repository
public class JdbcMovieDao implements MovieDao {
    private static final MovieRowMapper MOVIE_ROW_MAPPER = new MovieRowMapper();
    private final Logger log = LoggerFactory.getLogger(getClass());

    private String sqlGetAllMovies;
    private String sqlGetMovieById;
    private String sqlGetRandomMovies;
    private String sqlGetMoviesByGenreId;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcMovieDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setSqlGetAllMovies(@Value("${query.movie.sqlGetAllMovies}") String sqlGetAllMovies) {
        this.sqlGetAllMovies = sqlGetAllMovies;
    }

    @Autowired
    public void setSqlGetRandomMovies(@Value("${query.movie.sqlGetRandomMovies}") String sqlGetRandomMovies) {
        this.sqlGetRandomMovies = sqlGetRandomMovies;
    }

    @Autowired
    public void setSqlGetMoviesByGenreId(@Value("${query.movie.sqlGetMoviesByGenreId}") String sqlGetMoviesByGenreId) {
        this.sqlGetMoviesByGenreId = sqlGetMoviesByGenreId;
    }

    @Autowired
    public void setSqlGetMovieById(@Value("${query.movie.sqlGetMovieById}") String sqlGetMovieById) {
        this.sqlGetMovieById = sqlGetMovieById;
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

    @Override
    public Movie getById(int id) {
        return jdbcTemplate.queryForObject(sqlGetMovieById, MOVIE_ROW_MAPPER, id);
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
