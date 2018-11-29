package com.github.satsukd.dao;

import com.github.satsukd.entity.Movie;
import java.util.List;

public interface MovieDao {
    List<Movie> getAll();

    List<Movie> getRandom();

    List<Movie> getByGenreId(int genreId);
}
