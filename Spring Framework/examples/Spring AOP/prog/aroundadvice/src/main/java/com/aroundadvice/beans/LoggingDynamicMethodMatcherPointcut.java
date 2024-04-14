package com.aroundadvice.beans;

import java.lang.reflect.Method;

import org.springframework.aop.support.DynamicMethodMatcherPointcut;

public class LoggingDynamicMethodMatcherPointcut extends DynamicMethodMatcherPointcut {

	@Override
	public boolean matches(Method method, Class<?> targetClass, Object... args) {
		if (targetClass.isAssignableFrom(Calculator.class)) {
			if (method.getName().equals("add") || method.getName().equals("substract")) {
				if ((Integer) args[0] > 100 && (Integer) args[1] > 100) {
					return true;
				}
			}
		}
		return false;
	}

}
