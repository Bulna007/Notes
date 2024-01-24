package com.javaconfigpi.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigPITest {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfigPI.class);
//		Passport passport = context.getBean("passport", Passport.class);
//		Passport passport1 = context.getBean("passport", Passport.class);
//		
//		System.out.println(passport == passport1);
	}
}
