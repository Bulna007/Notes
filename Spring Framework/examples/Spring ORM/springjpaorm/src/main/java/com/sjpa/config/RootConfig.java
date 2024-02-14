package com.sjpa.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"com.sjpa.service"})
@Import({PersistenceConfig.class})
public class RootConfig {
}
