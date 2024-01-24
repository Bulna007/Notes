package com.bfpp.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import com.bfpp.beans.ConnectionFactory;

public class BFPPTest {
	public static void main(String[] args) {
		BeanFactory beanFactory = new DefaultListableBeanFactory();
		BeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) beanFactory);
		reader.loadBeanDefinitions(new ClassPathResource("com/bfpp/common/application-context.xml"));

		BeanFactoryPostProcessor bfpp = beanFactory.getBean("ppc", BeanFactoryPostProcessor.class);
		bfpp.postProcessBeanFactory((ConfigurableListableBeanFactory) beanFactory);

		ConnectionFactory connectionFactory = beanFactory.getBean("connectionFactory", ConnectionFactory.class);
		System.out.println(connectionFactory);
	}
}
