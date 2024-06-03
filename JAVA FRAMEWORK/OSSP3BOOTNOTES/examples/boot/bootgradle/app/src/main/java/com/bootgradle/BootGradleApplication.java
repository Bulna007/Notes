package com.bootgradle;

import com.bootgradle.beans.Project;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BootGradleApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BootGradleApplication.class, args);
        Project project = context.getBean(Project.class);
        System.out.println(project);
    }
}
