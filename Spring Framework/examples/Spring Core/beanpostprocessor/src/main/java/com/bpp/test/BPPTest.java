package com.bpp.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import com.bpp.beans.Tank;
import com.bpp.beans.Tower;
import com.bpp.helper.ObjectTracker;

public class BPPTest {
	public static void main(String[] args) {
		BeanFactory beanFactory = new DefaultListableBeanFactory();
		BeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) beanFactory);
		reader.loadBeanDefinitions(new ClassPathResource("com/bpp/common/application-context.xml"));

		BeanPostProcessor bpp = beanFactory.getBean("objectTrackerBeanPostProcessor", BeanPostProcessor.class);
		((ConfigurableListableBeanFactory) beanFactory).addBeanPostProcessor(bpp);

		Tank tank = beanFactory.getBean("tank", Tank.class);
		Tower tower = beanFactory.getBean("tower", Tower.class);

		System.out.println("no of objects instantiated by ioc container are : " + ObjectTracker.get());
	}
}
