package com.github.satsukd.controller;

import com.github.satsukd.controller.facade.entity.MovieFacade;
import com.github.satsukd.entity.Movie;
import com.github.satsukd.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {
    private final Logger log = LoggerFactory.getLogger(MovieController.class);

    private MovieService movieService;

    public MovieController(@Autowired MovieService movieService) {
        log.debug("MovieController constructor called with class {}", MovieService.class);
        this.movieService = movieService;
    }

    @RequestMapping(path = {"/v1/movie"}, method = RequestMethod.GET)
    public List<MovieFacade> getAll() {
        List<Movie> movies = movieService.getAll();
        List<MovieFacade> moviesFacade = new ArrayList<>();
        for (Movie movie : movies) {
            moviesFacade.add(new MovieFacade(movie));
        }

        return moviesFacade;
    }
}
