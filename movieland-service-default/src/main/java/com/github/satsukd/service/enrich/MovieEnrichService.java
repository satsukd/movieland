package com.github.satsukd.service.enrich;

import com.github.satsukd.entity.Genre;
import com.github.satsukd.entity.Movie;
import com.github.satsukd.service.GenreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.*;

@Service
public class MovieEnrichService {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private static ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

    static {
        executor.setCorePoolSize(10);
        executor.setMaximumPoolSize(20);
        executor.setKeepAliveTime(60, TimeUnit.MINUTES);
    }

    private static final int ENRICHMENT_TIMEOUT = 5;
    private GenreService genreService;

    @Autowired
    public void setGenreService(GenreService genreService) {
        this.genreService = genreService;
    }

    public void enrich(Movie movie) {
        logger.debug("started enrichment for movieId = {}", movie.getId());

        Callable<List<Genre>> genreCallable = () -> genreService.getByMovieId((int) movie.getId());

        Future<List<Genre>> genresFuture = executor.submit(genreCallable);

        try {
            List<Genre> genres = genresFuture.get(ENRICHMENT_TIMEOUT, TimeUnit.SECONDS);
            movie.setGenres(genres);
        } catch (Exception e) {
            logger.debug("failed enrich movieId {} with genres ", movie.getId());
        }

        logger.debug("enriched movie = {}", movie);
    }
}
