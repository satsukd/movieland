package com.github.satsukd.controller.dto

import com.github.satsukd.entity.Movie
import spock.lang.Specification

class MovieDTOGroovyTest extends Specification {
    private movieDTO
    private movie

    void setup() {
        movie = new Movie()
        movie.setId(1)
        movie.setNameRussian("Джанго")
        movie.setNameNative("Django")
        movie.setDescription("Длинное описание ... и этого метода не должно быть в MovieDTO")
        movie.setPrice(15.15)
        movie.setRating(8.6)
        movie.setYearOfRelease(2012)
        movie.setPicturePath("some_path")
        movieDTO = new MovieDTO()
        movieDTO.setId(1)
        movieDTO.setNameRussian("Джанго")
        movieDTO.setNameNative("Django")
        movieDTO.setPrice(15.15)
        movieDTO.setRating(8.6)
        movieDTO.setYearOfRelease(2012)
        movieDTO.setPicturePath("some_path")
    }

    def "GetId"() {
        expect:
        movie.getId() == movieDTO.getId()
    }

    def "GetNameRussian"() {
        expect:
        movie.getNameRussian() == movieDTO.getNameRussian()
    }

    def "GetNameNative"() {
        expect:
        movie.getNameNative() == movieDTO.getNameNative()
    }

    def "GetYearOfRelease"() {
        when: 'parse String value to int'
        def yearOfRelease = Integer.parseInt(movieDTO.getYearOfRelease())

        then: 'Compare converted results'
        movie.getYearOfRelease() == yearOfRelease
    }

    def "GetRating"() {
        expect:
        movie.getRating() == movieDTO.getRating()
    }

    def "GetPrice"() {
        expect:
        movie.getPrice() == movieDTO.getPrice()
    }

    def "GetPicturePath"() {
        expect:
        movie.getPicturePath() == movieDTO.getPicturePath()
    }

    def "GetDescription"() {
        when: 'call to not existing method'
        def description = movieDTO.getDescription()

        then: 'exception must be thrown'
        thrown MissingMethodException
    }
}
