package com.github.satsukd.dto;

import com.github.satsukd.entity.Genre;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class EnrichedMovieDTO {

    private long id;
    private String nameRussian;
    private String nameNative;
    private int yearOfRelease;
    private String description;
    private double rating;
    private double price;
    private String picturePath;
    private List<Genre> genres;

    public String getYearOfRelease() {
        return Integer.toString(yearOfRelease);
    }
}
