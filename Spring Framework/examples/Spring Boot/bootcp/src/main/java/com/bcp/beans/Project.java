package com.bcp.beans;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "project")
@Data
public class Project {
    private int id;
    private String title;
    private String client;
    private int teamSize;
    private int duration;
}
