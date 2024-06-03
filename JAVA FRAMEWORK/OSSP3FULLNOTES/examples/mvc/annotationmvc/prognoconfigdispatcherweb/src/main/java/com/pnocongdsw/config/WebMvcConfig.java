package com.pnocongdsw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.ParameterizableViewController;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Properties;

@Configuration
public class WebMvcConfig {

    @Bean
    public HandlerMapping handlerMapping() {
        Properties mappings = new Properties();
        mappings.put("/about-us.htm", "aboutUsController");

        SimpleUrlHandlerMapping handlerMapping = new SimpleUrlHandlerMapping();
        handlerMapping.setMappings(mappings);
        return handlerMapping;
    }

    @Bean
    public Controller aboutUsController() {
        ParameterizableViewController viewController = new ParameterizableViewController();
        viewController.setViewName("about-us");
        return viewController;
    }

    @Bean
    public ViewResolver jspViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
