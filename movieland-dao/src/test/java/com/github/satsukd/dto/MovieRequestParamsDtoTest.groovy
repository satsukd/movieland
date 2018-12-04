package com.github.satsukd.dto

import spock.lang.Specification

class MovieRequestParamsDtoTest extends Specification {


    def "Test addOrderClause" () {
        when: 'create MovieRequestParamsDto and put 4 enrties'
        MovieRequestParamsDto movieRequestParamsDto = new MovieRequestParamsDto()

        movieRequestParamsDto.addOrderClause(FiledNames.PRICE, OrderClause.ASC)
        movieRequestParamsDto.addOrderClause(FiledNames.RATING, OrderClause.ASC)
        movieRequestParamsDto.addOrderClause(FiledNames.PRICE, OrderClause.DESC)
        movieRequestParamsDto.addOrderClause(FiledNames.RATING, OrderClause.DESC)

        then: 'size of map equals to 2'
         movieRequestParamsDto.getOrderedFields().size() == 2
    }

}
