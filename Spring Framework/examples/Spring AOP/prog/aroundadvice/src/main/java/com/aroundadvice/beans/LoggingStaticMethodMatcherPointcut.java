package com.aroundadvice.beans;

import java.lang.reflect.Method;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

public class LoggingStaticMethodMatcherPointcut extends StaticMethodMatcherPointcut {

	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		if (targetClass.isAssignableFrom(Calculator.class)) {
			if (method.getName().equals("add") || method.getName().equals("substract")) {
				return true;
			}
		}
		return false;
	}

}
