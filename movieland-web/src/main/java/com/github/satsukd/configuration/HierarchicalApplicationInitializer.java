package com.github.satsukd.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class HierarchicalApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        logger.debug("called getRootConfigClasses");
        return new Class[]{ApplicationConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        logger.debug("called getServletConfigClasses");
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        logger.debug("called getServletMappings");
        return new String[]{"/v1/*"};
    }
}
