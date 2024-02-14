package com.bprofiles;

import com.bprofiles.beans.DataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BootProfileApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(BootProfileApplication.class, args);
        DataSource dataSource = applicationContext.getBean("dataSource", DataSource.class);
        System.out.println(dataSource);
    }
}
