package com.aa.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aa.beans.Calculator;
import com.aa.config.AAConfig;

public class AATest {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AAConfig.class);
		Calculator calculator = context.getBean("calculator",Calculator.class);
		int add = calculator.add(10, 20);
		System.out.println("sum : " + add);
		
		add = calculator.add(10, 20);
		System.out.println("sum : " + add);
	}
}
