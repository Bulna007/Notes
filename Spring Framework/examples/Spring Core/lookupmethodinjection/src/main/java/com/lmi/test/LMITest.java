package com.lmi.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import com.lmi.beans.Container;

public class LMITest {
	public static void main(String[] args) {
		BeanFactory beanFactory = new DefaultListableBeanFactory();
		BeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) beanFactory);
		reader.loadBeanDefinitions(new ClassPathResource("com/lmi/common/application-context.xml"));

		Container container = beanFactory.getBean("container", Container.class);
		System.out.println("container class:" + container.getClass().getName());

		for (int i = 0; i < 100; i++) {
			new Thread(new WebUser(container, "data" + i)).start();
		}
		// new Thread(new WebUser(container, "data2")).start();
		// new Thread(new WebUser(container, "data3")).start();

	}

	private final static class WebUser implements Runnable {
		private Container container;
		private String data;

		public WebUser(Container container, String data) {
			this.container = container;
			this.data = data;
		}

		@Override
		public void run() {
			container.receiveRequest(data);
		}
	}
}
