package com.github.satsukd.controller;

import com.github.satsukd.dto.*;
import com.github.satsukd.entity.Movie;
import com.github.satsukd.service.MovieService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
        validateRequestParamsDto(requestParamsDto);
        return wrapMovie(movieService.getAll(requestParamsDto));
    }

    @GetMapping(path = {"/movie/random"})
    public List<MovieDTO> getRandomMovie() {
        return wrapMovie(movieService.getRandom());
    }

    @GetMapping(path = {"/movie/genre/{genreId}"})
    public List<MovieDTO> getMovieByGenreId(@PathVariable int genreId, @ModelAttribute MovieRequestParamsDto requestParamsDto) {
        log.debug("MovieRequestParamsDto: {}", requestParamsDto);
        return wrapMovie(movieService.getByGenreId(genreId, requestParamsDto));
    }

    @GetMapping(path = {"/movie/{id}"})
    public EnrichedMovieDTO getMovieById(@PathVariable int id) {
        log.debug("getMovieById: {}", id);
        Movie movie = movieService.getById(id);
        return  modelMapper.map(movie, EnrichedMovieDTO.class);
    }

    private List<MovieDTO> wrapMovie(List<Movie> movies) {
        List<MovieDTO> moviesDTO = new ArrayList<>();
        for (Movie movie : movies) {
            moviesDTO.add(modelMapper.map(movie, MovieDTO.class));
        }

        return moviesDTO;
    }

    void validateRequestParamsDto(MovieRequestParamsDto movieRequestParamsDto) {
        if (movieRequestParamsDto.getPrice() != null) {
            OrderClause orderClause = OrderClause.getOrderClause(movieRequestParamsDto.getPrice());
            OrderClause.getOrderClause(movieRequestParamsDto.getPrice());
            movieRequestParamsDto.addOrderClause(FiledNames.PRICE, orderClause);
        }

        if (movieRequestParamsDto.getRating() != null) {
            OrderClause orderClause = OrderClause.getOrderClause(movieRequestParamsDto.getRating());
            OrderClause.getOrderClause(movieRequestParamsDto.getRating());
            movieRequestParamsDto.addOrderClause(FiledNames.RATING, orderClause);
        }
    }
}
