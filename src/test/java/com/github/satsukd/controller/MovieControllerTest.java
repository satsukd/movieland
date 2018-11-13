package com.github.satsukd.controller;

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

import java.util.ArrayList;
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
        movies = new ArrayList<>();
        Movie m1 = new Movie();
        m1.setId(1);
        m1.setNameNative("The Shawshank Redemption");
        m1.setNameRussian("Побег из Шоушенка");
        m1.setDescription("Успешный банкир Энди Дюфрейн обвинен в убийстве собственной жены и ее любовника. Оказавшись в тюрьме под названием Шоушенк, он сталкивается с жестокостью и беззаконием, царящими по обе стороны решетки. Каждый, кто попадает в эти стены, становится их рабом до конца жизни. Но Энди, вооруженный живым умом и доброй душой, отказывается мириться с приговором судьбы и начинает разрабатывать невероятно дерзкий план своего освобождения.");
        m1.setPrice(123.45);
        m1.setYearOfRelease(1995);
        m1.setRating(8.9);
        m1.setPicturePath("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg");
        movies.add(m1);
        when(movieService.getAll()).thenReturn(movies);
    }

    @Test
    public void getAll() throws Exception {

        mockMvc.perform(get("/v1/movie"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", equalTo(1)))
                .andExpect(jsonPath("$[0].nameRussian", equalTo("Побег из Шоушенка")))
                .andExpect(jsonPath("$[0].nameNative", equalTo("The Shawshank Redemption")))
                .andExpect(jsonPath("$[0].yearOfRelease", equalTo("1995")))
                .andExpect(jsonPath("$[0].rating", equalTo(8.9)))
                .andExpect(jsonPath("$[0].price", equalTo(123.45)))
                .andExpect(jsonPath("$[0].picturePath", equalTo("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg")));
    }
}