package com.github.satsukd.controller;

import com.github.satsukd.controller.dto.MovieDTO;
import com.github.satsukd.entity.Movie;
import com.github.satsukd.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private MovieService movieService;

    public MovieController(@Autowired MovieService movieService) {
        log.debug("MovieController constructor called with class {}", MovieService.class);
        this.movieService = movieService;
    }

    @GetMapping(path = {"/movie"})
    public List<MovieDTO> getAll() {
        List<Movie> movies = movieService.getAll();
        List<MovieDTO> moviesFacade = new ArrayList<>();
        for (Movie movie : movies) {
            moviesFacade.add(new MovieDTO(movie));
        }

        return moviesFacade;
    }
}
