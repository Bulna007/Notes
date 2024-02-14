package com.bp;

import com.bp.beans.Truck;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BootParentApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BootParentApplication.class, args);
        Truck truck = context.getBean("truck", Truck.class);
        truck.drive();
    }
}
