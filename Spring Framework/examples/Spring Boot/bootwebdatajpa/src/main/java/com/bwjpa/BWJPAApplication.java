package com.bwjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BWJPAApplication {

    /*@Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> webServerFactoryCustomizer() {
        return (factory -> {
            factory.setPort(8084);
        });
    }*/

    public static void main(String[] args) {
        SpringApplication.run(BWJPAApplication.class, args);
    }
}
