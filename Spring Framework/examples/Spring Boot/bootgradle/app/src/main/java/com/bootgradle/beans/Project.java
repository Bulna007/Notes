package com.bootgradle.beans;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Project {
    @Value("${id}")
    private int id;
    @Value("${title}")
    private String title;
}
