package com.github.satsukd.dataprovider;

import com.github.satsukd.entity.Genre;

import java.util.ArrayList;
import java.util.List;

public class GenreData {
    public static List<Genre> getGenreList() {
        List<Genre> genres = new ArrayList<>();

        Genre g1 = new Genre();
        g1.setId(1);
        g1.setName("дрма");
        genres.add(g1);

        Genre g2 = new Genre();
        g2.setId(2);
        g2.setName("комедия");
        genres.add(g2);

        Genre g3 = new Genre();
        g3.setId(3);
        g3.setName("фэнтези");
        genres.add(g3);

        return genres;
    }

}
