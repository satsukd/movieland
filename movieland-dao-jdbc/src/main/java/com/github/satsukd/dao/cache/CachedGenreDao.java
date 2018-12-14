package com.github.satsukd.dao.cache;

import com.github.satsukd.dao.GenreDao;
import com.github.satsukd.entity.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


@Repository
@Primary
public class CachedGenreDao implements GenreDao {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private volatile List<Genre> genres = new CopyOnWriteArrayList<>();
    private GenreDao genreDao;

    @Override
    public List<Genre> getAll() {
        return new ArrayList<>(genres);
    }

    @Override
    public List<Genre> getByMovieId(int movieId) {
        return genreDao.getByMovieId(movieId);
    }

    @Autowired
    public CachedGenreDao(@Qualifier("jdbcGenreDao") GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    @PostConstruct
    public void init() {
        log.debug("Executed init() over CachedGenreDao");
        genres = genreDao.getAll();
    }

    @Scheduled(initialDelayString = "${scheduler.initialDelay}", fixedRateString = "${scheduler.fixedDelay}")
    public void refreshCache() {
        log.debug("Executed refreshCache() over CachedGenreDao");
        init();
    }
}
