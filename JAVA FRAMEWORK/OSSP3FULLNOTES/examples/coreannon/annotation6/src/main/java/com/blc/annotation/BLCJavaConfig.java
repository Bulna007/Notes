package com.blc.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:com/blc/annotation/blc-values.properties")
@ComponentScan(basePackages = { "com.blc.annotation" })
public class BLCJavaConfig {

	@Bean(initMethod = "init", destroyMethod = "destroy")
	public Printer printer() {
		return new Printer();
	}
}
