package com.ehc.test;

import com.ehc.controller.CityController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ehc")
public class EventHandlingTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(EventHandlingTest.class);
        CityController cityController = applicationContext.getBean(CityController.class);
        int cityNo = cityController.addCity("Hyderabad");
        System.out.println("city no : " +cityNo);
    }

}
