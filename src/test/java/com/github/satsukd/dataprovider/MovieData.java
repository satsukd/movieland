package com.github.satsukd.dataprovider;

import com.github.satsukd.entity.Genre;
import com.github.satsukd.entity.Movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MovieData {
    public static List<Movie> getMovieList() {
        List<Movie> movies = new ArrayList<>();

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

        Movie m2 = new Movie();
        m2.setId(2);
        m2.setNameNative("The Shawshank Redemption part 2");
        m2.setNameRussian("Побег из Шоушенка часть 2");
        m2.setDescription("Успешный банкир Энди Дюфрейн снова обвинен в убийстве собственной жены и ее любовника. Оказавшись в тюрьме под названием Шоушенк, он сталкивается с жестокостью и беззаконием, царящими по обе стороны решетки. Каждый, кто попадает в эти стены, становится их рабом до конца жизни. Но Энди, вооруженный живым умом и доброй душой, отказывается мириться с приговором судьбы и начинает разрабатывать невероятно дерзкий план своего освобождения.");
        m2.setPrice(456.78);
        m2.setYearOfRelease(2025);
        m2.setRating(10);
        m2.setPicturePath("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg");
        movies.add(m2);

        Movie m3 = new Movie();
        m3.setId(3);
        m3.setNameNative("The Shawshank Redemption part 3");
        m3.setNameRussian("Побег из Шоушенка часть 3");
        m3.setDescription("Успешный банкир Энди Дюфрейн снова, в третий раз, обвинен в убийстве собственной жены и ее любовника. Оказавшись в тюрьме под названием Шоушенк, он сталкивается с жестокостью и беззаконием, царящими по обе стороны решетки. Каждый, кто попадает в эти стены, становится их рабом до конца жизни. Но Энди, вооруженный живым умом и доброй душой, отказывается мириться с приговором судьбы и начинает разрабатывать невероятно дерзкий план своего освобождения.");
        m3.setPrice(78.910);
        m3.setYearOfRelease(2125);
        m3.setRating(11);
        m3.setPicturePath("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg");
        movies.add(m3);


        return movies;
    }

    public static List<Movie> getMovieRandomList() {
        List<Movie> movies  = getMovieList();
        Random r = new Random();
        int index = r.nextInt(movies.size());
        return Arrays.asList(movies.get(index));
    }

}
