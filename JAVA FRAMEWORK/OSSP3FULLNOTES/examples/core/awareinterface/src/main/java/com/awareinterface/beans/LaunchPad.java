package com.awareinterface.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class LaunchPad implements BeanFactoryAware {
	private BeanFactory beanFactory;

	public void launch() {
		Rocket rocket = null;

		rocket = beanFactory.getBean("rocket", Rocket.class);
		rocket.propel();
		System.out.println("rocket has been launched....");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}

}
