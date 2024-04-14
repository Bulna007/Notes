package com.dependson.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import com.dependson.beans.LoanEnquiryManager;

public class DependsOnTest {
	public static void main(String[] args) {
		BeanFactory beanFactory = new DefaultListableBeanFactory();
		BeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) beanFactory);
		reader.loadBeanDefinitions(new ClassPathResource("com/dependson/common/application-context.xml"));
		
		LoanEnquiryManager loanEnquiryManager = beanFactory.getBean("loanEnquiryManager", LoanEnquiryManager.class);
		loanEnquiryManager.enquire(100000, 12, "hyderabad");
	}
}
