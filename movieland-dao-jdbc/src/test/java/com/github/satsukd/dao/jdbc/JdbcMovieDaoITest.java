package com.github.satsukd.dao.jdbc;

import com.github.satsukd.configuration.TestJdbcConfiguration;
import com.github.satsukd.dto.FiledNames;
import com.github.satsukd.dto.MovieRequestParamsDto;
import com.github.satsukd.dto.OrderClause;
import com.github.satsukd.entity.Movie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestJdbcConfiguration.class)
public class JdbcMovieDaoITest {

    private static final String ONE_QUALS_ONE = "1 = 1";

    @Autowired
    private JdbcMovieDao jdbcMovieDao;
    private MovieRequestParamsDto requestParamsDto = new  MovieRequestParamsDto();

    @Test
    public void getAll() {
        List<Movie> movies = jdbcMovieDao.getAll(requestParamsDto);
        assertEquals(6, movies.size());
    }

    @Test
    public void getRandom() {
        for (int i = 0; i < 10; i++) {
            assertNotSame(jdbcMovieDao.getRandom(), jdbcMovieDao.getRandom());
        }
    }

    @Test
    public void getByGenreId() {
        List<Movie> movies = jdbcMovieDao.getByGenreId(1, requestParamsDto);
        assertEquals(2, movies.size());
        movies.sort((o1, o2) -> Integer.compare((int)o1.getId(),(int) o2.getId()));
        assertEquals(1, movies.get(0).getId());
        assertEquals(2, movies.get(1).getId());
    }

    @Test
    public void applyRequestParamsEmptyParamsDto() {
        String actualQuery = jdbcMovieDao.applyRequestParams(ONE_QUALS_ONE, requestParamsDto);
        assertEquals(ONE_QUALS_ONE, actualQuery);
    }

    @Test
    public void applyRequestParamsNotEmptyParamsDto() {
        String expectedQuery = "1 = 1 ORDER BY PRICE ASC ";

        MovieRequestParamsDto requestParamsDtoObj = new  MovieRequestParamsDto();
        requestParamsDtoObj.getOrderedFields().put(FiledNames.PRICE, OrderClause.ASC);
        String actualQuery = jdbcMovieDao.applyRequestParams(ONE_QUALS_ONE, requestParamsDtoObj);
        assertEquals(expectedQuery, actualQuery);
    }
}