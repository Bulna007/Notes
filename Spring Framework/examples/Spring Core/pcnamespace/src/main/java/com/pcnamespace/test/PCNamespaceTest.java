package com.pcnamespace.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.pcnamespace.beans.Project;

public class PCNamespaceTest {
	public static void main(String[] args) {
		BeanFactory beanFactory = new XmlBeanFactory(
				new ClassPathResource("com/pcnamespace/common/application-context.xml"));
		Project project = beanFactory.getBean("project", Project.class);
		System.out.println(project);
	}
}
