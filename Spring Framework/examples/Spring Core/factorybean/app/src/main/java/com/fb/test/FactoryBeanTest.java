package com.fb.test;

import java.sql.SQLException;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import com.fb.beans.UserAccessor;

public class FactoryBeanTest {
	public static void main(String[] args) throws SQLException {
		BeanFactory beanFactory = new DefaultListableBeanFactory();
		BeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) beanFactory);
		reader.loadBeanDefinitions(new ClassPathResource("com/fb/common/application-context.xml"));
		
		UserAccessor userAccessor = beanFactory.getBean("userAccessor", UserAccessor.class);
		userAccessor.showUsers();
	}
}
