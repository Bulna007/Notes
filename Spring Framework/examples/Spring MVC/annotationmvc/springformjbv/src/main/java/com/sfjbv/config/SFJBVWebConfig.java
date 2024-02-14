package com.sfjbv.config;

import com.sfjbv.formatter.factory.MobileNumberAnnotationFormatterFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.sfjbv.controller", "com.sfjbv.validator", "com.sfjbv.formatter", "com.sfjbv.formatter.factory"})
public class SFJBVWebConfig implements WebMvcConfigurer {
    @Autowired
    private MobileNumberAnnotationFormatterFactory mobileNumberAnnotationFormatterFactory;

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("errors");
        return messageSource;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/jsp/", ".jsp");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatterForFieldAnnotation(mobileNumberAnnotationFormatterFactory);
    }
}
