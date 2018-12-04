package com.github.satsukd.dao.cache;

import com.github.satsukd.dao.jdbc.JdbcGenreDao;
import com.github.satsukd.entity.Genre;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/jdbc-context-test.xml", "classpath:spring/jdbc-context-cached-test.xml"})
public class CachedGenreDaoTest {

    @Autowired
    private JdbcGenreDao jdbcGenreDao;

    @Test
    public void getAll() {
        List<Genre> genres = jdbcGenreDao.getAll();
        assertEquals(15, genres.size());
    }
}