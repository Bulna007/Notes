package com.aa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.aa.helper.Cache;

@Configuration
@ComponentScan(basePackages = { "com.aa.beans", "com.aa.aspect" })
@EnableAspectJAutoProxy
public class AAConfig {

	@Bean
	public Cache cache() {
		return Cache.getInstance();
	}

}
