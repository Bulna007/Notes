package com.mr.test;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import com.mr.beans.PlanService;

public class MRTest {
	public static void main(String[] args) {
		BeanFactory beanFactory = new DefaultListableBeanFactory();
		BeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) beanFactory);
		reader.loadBeanDefinitions(new ClassPathResource("com/mr/common/application-context.xml"));

		PlanService planService = beanFactory.getBean("planService", PlanService.class);
		List<String> plans = planService.findPlans(30028, 23, "Female", 10, true, false);
		plans.forEach(System.out::println);
	}
}
