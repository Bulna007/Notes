package com.ci.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.ci.beans.Truck;

public class CITest {
	public static void main(String[] args) {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("com/ci/common/application-context.xml"));
		Truck truck = beanFactory.getBean("truck", Truck.class);
		truck.drive();
	}
}
