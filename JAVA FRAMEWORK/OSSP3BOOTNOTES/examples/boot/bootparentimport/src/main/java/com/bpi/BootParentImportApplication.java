package com.bpi;

import com.bpi.beans.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BootParentImportApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BootParentImportApplication.class, args);
        Person person = context.getBean("person", Person.class);
        System.out.println(person);
    }
}
