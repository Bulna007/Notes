package com.blc.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BLCTest {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(BLCJavaConfig.class);
		((ConfigurableApplicationContext) context).registerShutdownHook();

		Calculator clCalculator = context.getBean("calculator", Calculator.class);
		System.out.println(clCalculator);
	}
}
