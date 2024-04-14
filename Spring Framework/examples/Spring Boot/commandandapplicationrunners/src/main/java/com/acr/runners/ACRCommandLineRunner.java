package com.acr.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Order(2)
public class ACRCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("ACRCommandLineRunner is performing one-time startup activity : ");
        Arrays.stream(args).forEach(System.out::println);
    }
}
