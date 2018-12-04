package com.github.satsukd.dataprovider;

import com.github.satsukd.entity.Genre;

import java.util.ArrayList;
import java.util.List;

public class GenreData {
    public static List<Genre> getGenreList() {
        List<Genre> genres = new ArrayList<>();

        Genre g1 = new Genre(1, "драма");
        genres.add(g1);

        Genre g2 = new Genre(2, "комедия");
        genres.add(g2);

        Genre g3 = new Genre(3, "фэнтези");
        genres.add(g3);

        return genres;
    }

}
