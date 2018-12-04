package com.github.satsukd.dao.mapper;

import com.github.satsukd.entity.Movie;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;


public class MovieRowMapper implements RowMapper<Movie> {

    @Override
    public Movie mapRow(ResultSet resultSet, int i) throws SQLException {

        Movie movie = new Movie();

        int id = resultSet.getInt("id");
        String nameRussian = resultSet.getString("name_russian");
        String nameNative = resultSet.getString("name_native");
        String description = resultSet.getString("description");
        int yearOfRelease = resultSet.getInt("year_of_release");
        double rating = resultSet.getDouble("rating");
        double price = resultSet.getDouble("price");
        String picturePath = resultSet.getString("picture_path");
        Timestamp lastUpdateDate = resultSet.getTimestamp("last_update_date");
        if (lastUpdateDate != null) {
            LocalDateTime updateDate = lastUpdateDate.toLocalDateTime();
            movie.setLastUpdateDate(updateDate);
        }

        movie.setId(id);
        movie.setNameRussian(nameRussian);
        movie.setNameNative(nameNative);
        movie.setDescription(description);
        movie.setYearOfRelease(yearOfRelease);
        movie.setRating(rating);
        movie.setPrice(price);
        movie.setPicturePath(picturePath);

        return movie;
    }
}
