package com.github.satsukd.controller;

import com.github.satsukd.entity.Genre;
import com.github.satsukd.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GenreController {
    private GenreService genreService;

    public GenreController(@Autowired GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping(path = {"/genre"})
    public List<Genre> getAll() {
        return genreService.getAll();
    }
}
