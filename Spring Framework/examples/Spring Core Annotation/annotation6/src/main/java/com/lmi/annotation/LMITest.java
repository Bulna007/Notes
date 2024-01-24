package com.lmi.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LMITest {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext("com.lmi.annotation");
		Container container = context.getBean("container", Container.class);
		container.receive("data1");
	}
}
