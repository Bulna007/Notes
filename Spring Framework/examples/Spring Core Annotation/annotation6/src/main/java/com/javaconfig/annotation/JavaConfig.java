package com.javaconfig.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

	@Bean
	public Satelite newSatelite() {
		Satelite satelite = new Satelite();
		return satelite;
	}
}
