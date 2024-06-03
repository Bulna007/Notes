package com.bc.com.bc.beans;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "tournament")
public class Tournament {
    private int tournamentNo;
    private String tournamentName;
    private String host;
    private int participatingTeams;
    private int days;

}
