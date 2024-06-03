package com.reqannon.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.reqannon.beans.EMail;

public class ReqAnnonTest {
	public static void main(String[] args) {
//		BeanFactory beanFactory = new XmlBeanFactory(
//				new ClassPathResource("com/reqannon/common/application-context.xml"));
//		BeanPostProcessor bpp = beanFactory.getBean("rabpp", BeanPostProcessor.class);
//		((ConfigurableListableBeanFactory) beanFactory).addBeanPostProcessor(bpp);

		ApplicationContext context = new ClassPathXmlApplicationContext("com/reqannon/common/application-context.xml");
		EMail email = context.getBean("email", EMail.class);
		System.out.println(email);
	}
}
