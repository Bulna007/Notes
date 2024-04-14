package com.bcp;

import com.bcp.beans.Project;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BCPApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(BCPApplication.class, args);
        Project project = applicationContext.getBean("project", Project.class);
        System.out.println(project);
    }
}
