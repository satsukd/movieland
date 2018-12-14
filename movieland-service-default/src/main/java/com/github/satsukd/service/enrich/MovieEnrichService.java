package com.github.satsukd.service.enrich;

import com.github.satsukd.entity.Genre;
import com.github.satsukd.entity.Movie;
import com.github.satsukd.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieEnrichService {

    private GenreService genreService;

    @Autowired
    public void setGenreService(GenreService genreService) {
        this.genreService = genreService;
    }

    public void enrich(Movie movie) {
        List<Genre> genres = genreService.getByMovieId((int) movie.getId());
        movie.setGenres(genres);
    }
}
