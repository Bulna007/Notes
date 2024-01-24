package com.stereotype.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StereotypeTest {
	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext(
//				"com/stereotype/annotation/stereotype-beans.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext("com.stereotype.annotation");
//		Aeroplane aeroplane1 = context.getBean("boeing747", Aeroplane.class);
//		Aeroplane aeroplane2 = context.getBean("boeing747", Aeroplane.class);
//
//		System.out.println("aeroplane1 == aeroplane2 ? :" + (aeroplane1 == aeroplane2));
	}
}
