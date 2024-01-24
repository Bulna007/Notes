package com.aroundadvice.test;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import com.aroundadvice.beans.CacheAdvice;
import com.aroundadvice.beans.CacheStaticMethodMatcherPointcut;
import com.aroundadvice.beans.Calculator;
import com.aroundadvice.beans.LoggingAdvice;
import com.aroundadvice.beans.LoggingDynamicMethodMatcherPointcut;

public class Test {
	public static void main(String[] args) {
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(new Calculator());

		// proxyFactory.addAdvice(new CacheAdvice());
		// proxyFactory.addAdvice(new LoggingAdvice());
		proxyFactory
				.addAdvisor(new DefaultPointcutAdvisor(new LoggingDynamicMethodMatcherPointcut(), new LoggingAdvice()));
		proxyFactory.addAdvisor(new DefaultPointcutAdvisor(new CacheStaticMethodMatcherPointcut(), new CacheAdvice()));

		Calculator proxy = (Calculator) proxyFactory.getProxy();
		// Calculator proxy = new Calculator();
		int sum = proxy.add(101, 201);
		System.out.println("sum : " + sum);
		sum = proxy.add(10, 20);
		System.out.println("sum : " + sum);

		int sub = proxy.substract(10, 20);
		System.out.println("substract: " + sub);

		sub = proxy.substract(101, 201);
		System.out.println("substract: " + sub);

		int mul = proxy.multiply(10, 20);
		System.out.println("mul : " + mul);

		mul = proxy.multiply(10, 20);
		System.out.println("mul : " + mul);

		// logging=add, substract
		// cache=multiplication
	}
}
