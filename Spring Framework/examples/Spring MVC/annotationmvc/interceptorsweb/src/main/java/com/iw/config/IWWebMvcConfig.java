package com.iw.config;

import com.iw.interceptors.MaintenanceWindowInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.iw.interceptors"})
public class IWWebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private MaintenanceWindowInterceptor maintenanceWindowInterceptor;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/book-ticket.htm").setViewName("book-ticket");
        registry.addViewController("/plan-my-travel.htm").setViewName("plan-my-travel");
        registry.addViewController("/pnr-status.htm").setViewName("pnr-status");
        registry.addViewController("/print-ticket.htm").setViewName("print-ticket");
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/jsp/", ".jsp");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(maintenanceWindowInterceptor)
                .addPathPatterns("/plan-my-travel.htm", "/book-ticket.htm");
    }
}
