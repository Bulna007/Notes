package com.profiles.annotation;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile("dev")
@PropertySource("classpath:com/profiles/annotation/values-dev.properties")
public class DevConfig {

}
