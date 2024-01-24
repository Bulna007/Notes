package com.primary.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = { "com.primary.annotation" })
public class PJavaConfig {

	@Primary
	@Bean
	public Wheel wheel1() {
		Wheel wheel = new Wheel();
		wheel.setRadius(10);
		return wheel;
	}

	@Bean
	public Wheel wheel2() {
		Wheel wheel = new Wheel();
		wheel.setRadius(12);
		return wheel;
	}

}
