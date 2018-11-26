package com.github.satsukd.dao.mapper;

import com.github.satsukd.entity.Genre;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class GenreRowMapper implements RowMapper<Genre> {

    @Override
    public Genre mapRow(ResultSet resultSet, int i) throws SQLException {

        Genre genre = new Genre();

        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");

        genre.setId(id);
        genre.setName(name);

        return genre;
    }
}
