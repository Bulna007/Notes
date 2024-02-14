package com.bextconf.beans;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class Project {
    @Value("${id}")
    private int id;
    @Value("${projectName}")
    private String projectName;
    @Value("${duration}")
    private int duration;
    @Value("${teamSize}")
    private int teamSize;

}