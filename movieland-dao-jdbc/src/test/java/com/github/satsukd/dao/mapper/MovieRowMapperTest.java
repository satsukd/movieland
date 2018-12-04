package com.github.satsukd.dao.mapper;

import com.github.satsukd.entity.Movie;
import org.junit.Before;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MovieRowMapperTest {

    private ResultSet resultSet;
    private Movie expectedMovie;

    @Before
    public void setUp() throws Exception {
        resultSet = mock(ResultSet.class);

        when(resultSet.getInt("id")).thenReturn(1);
        when(resultSet.getString("name_russian")).thenReturn("Джанго");
        when(resultSet.getString("name_native")).thenReturn("Django");
        when(resultSet.getString("description")).thenReturn("Длинное описание ...");
        when(resultSet.getInt("year_of_release")).thenReturn(2012);
        when(resultSet.getDouble("rating")).thenReturn(8.6);
        when(resultSet.getDouble("price")).thenReturn(15.15);
        when(resultSet.getString("picture_path")).thenReturn("some_path");

        expectedMovie = new Movie();
        expectedMovie.setId(1);
        expectedMovie.setNameRussian("Джанго");
        expectedMovie.setNameNative("Django");
        expectedMovie.setDescription("Длинное описание ...");
        expectedMovie.setPrice(15.15);
        expectedMovie.setRating(8.6);
        expectedMovie.setYearOfRelease(2012);
        expectedMovie.setPicturePath("some_path");
    }

    @Test
    public void mapRow() throws SQLException {
        MovieRowMapper movieRowMapper = new MovieRowMapper();
        Movie actialMovie = movieRowMapper.mapRow(resultSet, -1);
        assertEquals(expectedMovie, actialMovie);
    }
}