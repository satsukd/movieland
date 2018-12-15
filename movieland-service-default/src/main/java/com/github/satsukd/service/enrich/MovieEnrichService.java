package com.github.satsukd.service.enrich;

import com.github.satsukd.entity.Genre;
import com.github.satsukd.entity.Movie;
import com.github.satsukd.service.GenreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Service
public class MovieEnrichService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private static ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
    private GenreService genreService;
    private int enrichTimeoutMilSeconds;
    private int executorCorePollSize;
    private int executorMaxPollSize;
    private int executorKeepAliveMilSeconds;


    public void enrich(Movie movie) {
        List<Callable<Movie>> tasks = new ArrayList<>();

        MovieEnrichmentTask movieWithGenresEnrichment = new MovieEnrichmentTask(movie, movie1 -> {
            List<Genre> genreList = genreService.getByMovieId(movie1.getId());
            movie1.setGenres(genreList);
        }, "genres");

        tasks.add(movieWithGenresEnrichment);

        MovieEnrichmentTask movieWithCountyEnrichment = new MovieEnrichmentTask(movie, movie1 -> {
            List<Genre> genreList = genreService.getByMovieId(movie1.getId());
            movie1.setGenres(genreList);
        }, "counties");

        tasks.add(movieWithCountyEnrichment);

        try {
            logger.debug("started movie {} enrichment ", movie.getId());
            List<Future<Movie>> movieFutures = executor.invokeAll(tasks, enrichTimeoutMilSeconds, TimeUnit.MILLISECONDS);
            long finishedTasks = movieFutures.stream().filter(future -> !future.isCancelled() && future.isDone()).count();
            logger.info("ended movie {} enrichment, {} tasks were finished, {} tasks were failed ", movie.getId(), finishedTasks, movieFutures.size() - finishedTasks);
        } catch (InterruptedException e) {
            logger.info("movie {} enrichment was interrupted ", movie.getId());
            logger.debug("ERROR: {}", e);
        }
    }

    @Autowired
    public void setGenreService(GenreService genreService) {
        this.genreService = genreService;
    }

    @PostConstruct
    public void init() {
        executor.setCorePoolSize(executorCorePollSize);
        executor.setMaximumPoolSize(executorMaxPollSize);
        executor.setKeepAliveTime(executorKeepAliveMilSeconds, TimeUnit.MILLISECONDS);
    }

    @PreDestroy
    public void destroy() {
        executor.shutdown();
    }


    @Value("${movie.enrichTimeoutMilSeconds}")
    public void setEnrichTimeoutMilSeconds(int enrichTimeoutMilSeconds) {
        this.enrichTimeoutMilSeconds = enrichTimeoutMilSeconds;
    }

    @Value("${executor.executorCorePollSize}")
    public void setExecutorCorePollSize(int executorCorePollSize) {
        this.executorCorePollSize = executorCorePollSize;
    }

    @Value("${executor.executorMaxPollSize}")
    public void setExecutorMaxPollSize(int executorMaxPollSize) {
        this.executorMaxPollSize = executorMaxPollSize;
    }

    @Value("${executor.executorKeepAliveMilSeconds}")
    public void setExecutorKeepAliveMilSeconds(int executorKeepAliveMilSeconds) {
        this.executorKeepAliveMilSeconds = executorKeepAliveMilSeconds;
    }
}
