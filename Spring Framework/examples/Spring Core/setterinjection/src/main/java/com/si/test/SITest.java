package com.si.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.si.beans.Remote;

public class SITest {
	public static void main(String[] args) {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("com/si/common/application-context.xml"));
		Remote remote = beanFactory.getBean("remote", Remote.class);
		remote.poweron();
	}
}
