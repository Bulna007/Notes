package com.bextconf;

import com.bextconf.beans.Project;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BootExtConfigApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BootExtConfigApplication.class, args);
        Project project = context.getBean("project", Project.class);
        System.out.println(project);
    }
}
