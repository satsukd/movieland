package com.github.satsukd.controller;

import com.github.satsukd.dataprovider.MovieData;
import com.github.satsukd.entity.Movie;
import com.github.satsukd.service.MovieService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContext.xml", "file:src/main/webapp/WEB-INF/rest-api-servlet.xml", "classpath:applicationContext-test.xml"})
@WebAppConfiguration
public class MovieControllerTest {
    private MockMvc mockMvc;
    private List<Movie> movies;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MovieService movieService;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        movies = MovieData.getMovieList();
        when(movieService.getAll()).thenReturn(movies);
    }

    @Test
    public void getAll() throws Exception {

        List<Movie> actualMovies = MovieData.getMovieList();

        mockMvc.perform(get("/v1/movie"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", equalTo(1)))
                .andExpect(jsonPath("$[0].nameRussian", equalTo(actualMovies.get(0).getNameRussian())))
                .andExpect(jsonPath("$[0].nameNative", equalTo(actualMovies.get(0).getNameNative())))
                .andExpect(jsonPath("$[0].yearOfRelease", equalTo(((Integer) actualMovies.get(0).getYearOfRelease()).toString())))
                .andExpect(jsonPath("$[0].rating", equalTo(actualMovies.get(0).getRating())))
                .andExpect(jsonPath("$[0].price", equalTo(actualMovies.get(0).getPrice())))
                .andExpect(jsonPath("$[0].picturePath", equalTo(actualMovies.get(0).getPicturePath())))
                .andExpect(jsonPath("$[1].id", equalTo(2)))
                .andExpect(jsonPath("$[1].nameRussian", equalTo(actualMovies.get(1).getNameRussian())))
                .andExpect(jsonPath("$[1].nameNative", equalTo(actualMovies.get(1).getNameNative())))
                .andExpect(jsonPath("$[1].yearOfRelease", equalTo(((Integer) actualMovies.get(1).getYearOfRelease()).toString())))
                .andExpect(jsonPath("$[1].rating", equalTo(actualMovies.get(1).getRating())))
                .andExpect(jsonPath("$[1].price", equalTo(actualMovies.get(1).getPrice())))
                .andExpect(jsonPath("$[1].picturePath", equalTo(actualMovies.get(1).getPicturePath())));
    }
}