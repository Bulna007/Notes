package com.be.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("executing CommandLineRunner, for performing one-time startup action/activity for the application");
        throw new IllegalAccessException("failed initializing..");
    }
}
