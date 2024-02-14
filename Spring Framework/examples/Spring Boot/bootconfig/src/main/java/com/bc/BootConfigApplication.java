package com.bc;

import com.bc.com.bc.beans.Tournament;
import com.bc.factories.YamlPropertySourceFactory;
import com.bc.initializers.YamlConfigApplicationContextInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(name="app-config", value = "classpath:app-config.yml", factory = YamlPropertySourceFactory.class)
public class BootConfigApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(BootConfigApplication.class, args);
//        YamlConfigApplicationContextInitializer initializer = new YamlConfigApplicationContextInitializer();
//        SpringApplication springApplication = new SpringApplicationBuilder(BootConfigApplication.class)
//                .initializers(initializer).build();
//        ApplicationContext applicationContext = springApplication.run(args);

        Tournament tournament = applicationContext.getBean("tournament", Tournament.class);
        System.out.println(tournament);
    }
}
