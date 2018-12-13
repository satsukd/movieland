package com.github.satsukd.configuration;

import liquibase.integration.spring.SpringLiquibase;
import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.sql.DataSource;

@Configuration
@EnableScheduling
@ComponentScan(basePackages = {"com.github.satsukd.dao.jdbc"})
public class TestJdbcConfiguration {

    @Bean
    JdbcTemplate jdbcTemplate(DataSource dataSource) {
        logger.debug("called jdbcTemplate bean");
        return new JdbcTemplate(dataSource);
    }

    private static final Logger logger = LoggerFactory.getLogger(TestJdbcConfiguration.class);


    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholder(YamlPropertiesFactoryBean yamlPropertiesFactoryBean) {
        logger.debug("called propertySourcesPlaceholder bean");
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        propertySourcesPlaceholderConfigurer.setProperties(yamlPropertiesFactoryBean.getObject());
        return propertySourcesPlaceholderConfigurer;
    }

    @Bean
    YamlPropertiesFactoryBean yamlProperties()  {
        logger.debug("called yamlProperties bean");
        YamlPropertiesFactoryBean yamlPropertiesFactoryBean = new YamlPropertiesFactoryBean();
        ClassPathResource classPathResource = new ClassPathResource("db/properties-liquibase.yml");
        yamlPropertiesFactoryBean.setResources(classPathResource, new ClassPathResource("db/sqlQueries.yml"));
        return yamlPropertiesFactoryBean;
    }

    @Bean
    DataSource dataSource(@Value("${jdbc.driver}") String driverClassName,
                          @Value("${jdbc.url}") String url,
                          @Value("${jdbc.username}") String username,
                          @Value("${jdbc.password}") String password,
                          @Value("${jdbc.initialSize}") int initialSize,
                          @Value("${jdbc.maxTotal}") int maxTotal
    ) {
        logger.debug("called dataSource bean");
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(driverClassName);
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);
        basicDataSource.setInitialSize(initialSize);
        basicDataSource.setMaxTotal(maxTotal);

        return basicDataSource;
    }

    @Bean
    SpringLiquibase liquibase(DataSource dataSource) {
        logger.debug("called liquibase bean");
        SpringLiquibase springLiquibase = new SpringLiquibase();
        springLiquibase.setDataSource(dataSource);
        springLiquibase.setChangeLog("classpath:db/liquibase/databaseChangeLog.xml");

        return springLiquibase;
    }
}
