package com.bl.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import com.bl.beans.Calculator;

public class BLTest {
	public static void main(String[] args) {
		BeanFactory beanFactory = new DefaultListableBeanFactory();
		BeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) beanFactory);
		reader.loadBeanDefinitions(new ClassPathResource("com/bl/common/application-context.xml"));
		Runnable shutdownHook = beanFactory.getBean("shutdownHook", Runnable.class);

		// register the shutdownhook
		Runtime.getRuntime().addShutdownHook(new Thread(shutdownHook));

		Calculator calculator = beanFactory.getBean("calculator", Calculator.class);
		
		System.out.println(calculator);
		// ((ConfigurableListableBeanFactory)beanFactory).destroySingletons();
	}
}
