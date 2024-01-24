package com.lmi.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

abstract public class Container /*implements BeanFactoryAware*/{
	//private BeanFactory beanFactory;

	public void receiveRequest(String data) {
		Worker worker = null;
		
		//worker = beanFactory.getBean("worker", Worker.class);
		worker = lookupWorker();
		worker.setData(data);
		worker.processRequest();
	}

//	@Override
//	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
//		this.beanFactory = beanFactory;
//	}
	
	abstract Worker lookupWorker();
}
