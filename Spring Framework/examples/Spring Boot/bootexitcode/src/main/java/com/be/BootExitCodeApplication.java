package com.be;

import com.be.beans.Robot;
import org.springframework.boot.ExitCodeEvent;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

import javax.swing.*;

@SpringBootApplication
public class BootExitCodeApplication {

    @Bean
    public ExitCodeGenerator exitCodeGenerator() {
        return () -> 10; // we are creating the object of ExitCodeGenerator
        // by overriding getExitCode() method and return 10
    }

    @Bean
    public ApplicationListener<ExitCodeEvent> exitCodeEventApplicationListener() {
        return (exitCodeEvent)-> System.out.println("exitcode: " + exitCodeEvent.getExitCode());
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(BootExitCodeApplication.class, args);
        try {
            Robot robot = applicationContext.getBean(Robot.class);
            robot.walk();
        } finally {
            int exitcode = SpringApplication.exit(applicationContext);
            System.exit(exitcode);
        }
    }
}
