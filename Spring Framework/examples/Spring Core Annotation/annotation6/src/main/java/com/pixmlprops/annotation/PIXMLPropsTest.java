package com.pixmlprops.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PIXMLPropsTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/pixmlprops/annotation/pixmlprops-beans.xml");
		
		Person person = context.getBean("person", Person.class);
		System.out.println(person);
	}
}
