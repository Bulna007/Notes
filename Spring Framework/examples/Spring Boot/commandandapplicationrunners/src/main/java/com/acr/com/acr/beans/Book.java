package com.acr.com.acr.beans;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "book")
@Component
public class Book {
    private String isbn;
    private String title;


}
