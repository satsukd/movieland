package com.github.satsukd.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.github.satsukd.service")
@Import(value = {JdbcConfiguration.class})
public class ServiceConfig {

}
