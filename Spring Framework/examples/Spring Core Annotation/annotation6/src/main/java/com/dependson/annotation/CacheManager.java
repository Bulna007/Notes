package com.dependson.annotation;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("loanEnquire")
public class CacheManager {

	public CacheManager() {
		System.out.println("CacheManager()");
	}

}
