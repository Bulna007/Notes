package com.acr;

import com.acr.com.acr.beans.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ACRBootApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(ACRBootApplication.class, args);
        try {
            // application programming logic
            System.out.println("application programming logic .....");
            Book book = applicationContext.getBean("book", Book.class);
            System.out.println(book);
        } finally {
            int exitCode = SpringApplication.exit(applicationContext);
            System.exit(exitCode);
        }
    }

}
