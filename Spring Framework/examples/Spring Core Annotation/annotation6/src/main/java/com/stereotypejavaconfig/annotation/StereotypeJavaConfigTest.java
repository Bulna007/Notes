package com.stereotypejavaconfig.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StereotypeJavaConfigTest {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SJavaConfig.class);
		Robot robot = context.getBean("robot", Robot.class);
		System.out.println(robot);
	}
}
