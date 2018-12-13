package com.github.satsukd.configuration;

import com.github.satsukd.service.MovieService;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value={ServiceConfig.class})
public class TestApplicationConfig {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Bean
    MovieService movieService() {
        logger.debug("called movieService test bean, mocked MovieService");
        return Mockito.mock(MovieService.class);
    }

}
