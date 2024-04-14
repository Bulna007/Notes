package com.stereotypejavaconfig.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:com/stereotypejavaconfig/annotation/sjavaconfigvalues.properties")
@ComponentScan(basePackages = { "com.stereotypejavaconfig.annotation" })
public class SJavaConfig {

	@Bean
	public Chip chip(@Value("${chipType}") String chipType) {
		Chip chip = new Chip();
		chip.setChipType(chipType);
		return chip;
	}
}
