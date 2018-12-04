package com.github.satsukd.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {ServiceConfig.class})
public class ApplicationConfig {
}
