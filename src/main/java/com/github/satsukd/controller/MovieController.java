package com.github.satsukd.controller;

import com.github.satsukd.controller.dto.MovieDTO;
import com.github.satsukd.controller.dto.MovieRequestParamsDto;
import com.github.satsukd.entity.Movie;
import com.github.satsukd.service.MovieService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final ModelMapper modelMapper = new ModelMapper();

    private MovieService movieService;

    public MovieController(@Autowired MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(path = {"/movie"})
    public List<MovieDTO> getAll(@ModelAttribute MovieRequestParamsDto requestParamsDto) {
        log.debug("MovieRequestParamsDto: {}", requestParamsDto);
        return wrappMovie(movieService.getAll(requestParamsDto));
    }

    @GetMapping(path = {"/movie/random"})
    public List<MovieDTO> getRandomMovie() {
        return wrappMovie(movieService.getRandom());
    }

    private List<MovieDTO> wrappMovie(List<Movie> movies) {

        List<MovieDTO> moviesDTO = new ArrayList<>();
        for (Movie movie : movies) {
            moviesDTO.add(modelMapper.map(movie, MovieDTO.class));
        }

        return moviesDTO;
    }
}
