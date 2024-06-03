package com.beh;

import com.beh.listener.BootApplicationListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BEHApplication {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplicationBuilder(BEHApplication.class).listeners(new BootApplicationListener()).build();
        ApplicationContext context = springApplication.run(args);
        System.out.println("boot application started");
    }
}
