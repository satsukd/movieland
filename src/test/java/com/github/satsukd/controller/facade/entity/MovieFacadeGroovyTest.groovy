package com.github.satsukd.controller.facade.entity

import com.github.satsukd.entity.Movie
import spock.lang.Specification

class MovieFacadeGroovyTest extends Specification {
    private movieFacade
    private movie

    void setup() {
        movie = new Movie()
        movie.setId(1)
        movie.setNameRussian("Джанго")
        movie.setNameNative("Django")
        movie.setDescription("Длинное описание ... и этого метода не должно быть в MovieFacade")
        movie.setPrice(15.15)
        movie.setRating(8.6)
        movie.setYearOfRelease(2012)
        movie.setPicturePath("some_path")
        movieFacade = new MovieFacade(movie)
    }

    def "GetId"() {
        expect:
        movie.getId() == movieFacade.getId()
    }

    def "GetNameRussian"() {
        expect:
        movie.getNameRussian() == movieFacade.getNameRussian()
    }

    def "GetNameNative"() {
        expect:
        movie.getNameNative() == movieFacade.getNameNative()
    }

    def "GetYearOfRelease"() {
        when: 'parse String value to int'
        def yearOfRelease = Integer.parseInt(movieFacade.getYearOfRelease())

        then: 'Compare converted results'
        movie.getYearOfRelease() == yearOfRelease
    }

    def "GetRating"() {
        expect:
        movie.getRating() == movieFacade.getRating()
    }

    def "GetPrice"() {
        expect:
        movie.getPrice() == movieFacade.getPrice()
    }

    def "GetPicturePath"() {
        expect:
        movie.getPicturePath() == movieFacade.getPicturePath()
    }

    def "GetDescription"() {
        when: 'call to not existing method'
        def description = movieFacade.getDescription()

        then: 'exception must be thrown'
        thrown MissingMethodException
    }
}
