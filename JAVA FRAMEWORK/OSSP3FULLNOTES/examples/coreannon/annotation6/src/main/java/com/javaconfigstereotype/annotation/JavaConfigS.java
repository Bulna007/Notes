package com.javaconfigstereotype.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:com/javaconfigstereotype/annotation/javaconfigsvalues.properties")
@ComponentScan(basePackages = {"com.javaconfigstereotype.annotation"})
public class JavaConfigS {
	
	@Bean
	public Launcher launcher(Rocket rocket) {
		Launcher launcher = new Launcher();
		launcher.setRocket(rocket);
		return launcher;
	}

}
