package com.stereotypepi.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StereotypePITest {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext("com.stereotypepi.annotation");
		Address address = context.getBean("address", Address.class);
		System.out.println(address);
	}

}
