package com.pi.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.pi.beans.FuelTank;

public class PITest {
	public static void main(String[] args) {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("com/pi/common/application-context.xml"));
		FuelTank fuelTank = beanFactory.getBean("fuelTank", FuelTank.class);
		System.out.println(fuelTank);
	}
}
