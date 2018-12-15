package com.github.satsukd.dao;

import com.github.satsukd.dto.MovieRequestParamsDto;
import com.github.satsukd.entity.Movie;

import java.util.List;

public interface MovieDao {
    List<Movie> getAll(MovieRequestParamsDto requestParamsDto);

    List<Movie> getRandom();

    List<Movie> getByGenreId(int genreId, MovieRequestParamsDto requestParamsDto);

    Movie getById(int id);
}
