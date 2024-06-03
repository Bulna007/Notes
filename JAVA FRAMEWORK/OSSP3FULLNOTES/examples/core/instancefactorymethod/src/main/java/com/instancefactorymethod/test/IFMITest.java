package com.instancefactorymethod.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import com.instancefactorymethod.beans.CargoManager;

public class IFMITest {
	public static void main(String[] args) {
		BeanFactory beanFactory = new DefaultListableBeanFactory();
		BeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) beanFactory);
		reader.loadBeanDefinitions(new ClassPathResource("com/instancefactorymethod/common/application-context.xml"));

		CargoManager cargoManager = beanFactory.getBean("cargoManager", CargoManager.class);
		int tripNo = cargoManager.scheduleTruck(93);
		System.out.println("scheduled tripNo  :" + tripNo);
	}
}
