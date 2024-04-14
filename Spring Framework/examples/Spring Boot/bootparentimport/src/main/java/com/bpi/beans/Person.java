package com.bpi.beans;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class Person {
    @Value("${id}")
    private int id;
    @Value("${fullname}")
    private String fullname;
}
