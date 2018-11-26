package com.github.satsukd.controller;

import com.github.satsukd.entity.Genre;
import com.github.satsukd.service.GenreService;
import com.github.satsukd.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GenreController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private GenreService genreService;

    public GenreController(@Autowired GenreService genreService) {
        log.debug("MovieController constructor called with class {}", MovieService.class);
        this.genreService = genreService;
    }

    @GetMapping(path = {"/genre"})
    public List<Genre> getAll() {
        return genreService.getAll();
    }
}
