package com.profiles.annotation;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile("test")
@PropertySource("classpath:com/profiles/annotation/values-test.properties")

public class TestConfig {

}