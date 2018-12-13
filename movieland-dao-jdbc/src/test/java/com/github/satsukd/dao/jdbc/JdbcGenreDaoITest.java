package com.github.satsukd.dao.jdbc;

import com.github.satsukd.entity.Genre;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/jdbc-context-liquibase-test.xml"})
public class JdbcGenreDaoITest {

    @Autowired
    private JdbcGenreDao jdbcGenreDao;

    @Test
    public void getAll() {
        List<Genre> genres  = jdbcGenreDao.getAll();
        assertEquals(15, genres.size());
    }
}