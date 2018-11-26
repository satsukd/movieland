package com.github.satsukd.service;

import com.github.satsukd.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAll();

    List<Movie> getRandom();
}
