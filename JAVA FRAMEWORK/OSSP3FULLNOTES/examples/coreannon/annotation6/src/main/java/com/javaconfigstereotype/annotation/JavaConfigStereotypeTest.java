package com.javaconfigstereotype.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigStereotypeTest {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfigS.class);
		Launcher launcher = context.getBean("launcher", Launcher.class);
		System.out.println(launcher);
	}
}
