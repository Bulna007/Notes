package com.be.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Robot {

    public void walk() {
        System.out.println("walking...");
    }

    @PostConstruct
    public void initialize() {
        System.out.println("initializing...");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroying...");
    }
}
