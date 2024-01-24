package com.primary.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PrimaryTest {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(PJavaConfig.class);
		Bicycle bicycle = context.getBean("bicycle", Bicycle.class);
		System.out.println(bicycle);
	}
}
