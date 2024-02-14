package com.bootcustomization.beans;

import org.springframework.stereotype.Component;

@Component
public class Truck {
    public void start() {
        System.out.println("truck is starting");
    }
}
