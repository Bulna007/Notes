package com.bootcustomization;

import com.bootcustomization.beans.Truck;
import org.springframework.boot.Banner;
import org.springframework.boot.ResourceBanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

import java.io.PrintStream;

@SpringBootApplication
public class BootCustomizationApplication {
    public static void main(String[] args) {
        //ApplicationContext context = SpringApplication.run(BootCustomizationApplication.class, args);
//        SpringApplicationBuilder springApplicationBuilder = new SpringApplicationBuilder(BootCustomizationApplication.class);
//        springApplicationBuilder.bannerMode(Banner.Mode.OFF);
//        SpringApplication springApplication = springApplicationBuilder.build();
//
//        ApplicationContext context = springApplication.run(args);

//        ApplicationContext context = new SpringApplicationBuilder(BootCustomizationApplication.class).banner(new Banner() {
//            @Override
//            public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
//                out.println("Thank you");
//            }
//        }).build().run(args);
        ApplicationContext context = new SpringApplicationBuilder(BootCustomizationApplication.class).
                banner(new ResourceBanner(new ClassPathResource("banner1.txt")))
                .build().run(args);
        Truck truck = context.getBean(Truck.class);
        truck.start();
    }
}
