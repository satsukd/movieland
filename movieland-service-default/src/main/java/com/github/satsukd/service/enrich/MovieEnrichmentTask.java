package com.github.satsukd.service.enrich;

import com.github.satsukd.entity.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.function.Consumer;

public class MovieEnrichmentTask implements Callable<Movie> {

    private static final Logger logger = LoggerFactory.getLogger(MovieEnrichmentTask.class);

    private Movie movie;
    private Consumer<Movie> movieConsumer;
    private String taskName;

    public MovieEnrichmentTask(Movie movie, Consumer<Movie> movieConsumer, String taskName) {
        this.movie = movie;
        this.movieConsumer = movieConsumer;
        this.taskName = taskName;
    }

    @Override
    public Movie call() throws Exception {
        logger.debug("movie {} inside enrichment {}", movie.getId(),taskName);
        movieConsumer.accept(movie);
        logger.debug("movie {} enriched with {}", movie.getId(), taskName);
        return movie;
    }

    public String getTaskName() {
        return taskName;
    }
}
