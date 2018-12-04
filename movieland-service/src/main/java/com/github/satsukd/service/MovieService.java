package com.github.satsukd.service;

import com.github.satsukd.dto.MovieRequestParamsDto;
import com.github.satsukd.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAll(MovieRequestParamsDto requestParamsDto);

    List<Movie> getRandom();

    List<Movie> getByGenreId(int genreId, MovieRequestParamsDto requestParamsDto);
}
