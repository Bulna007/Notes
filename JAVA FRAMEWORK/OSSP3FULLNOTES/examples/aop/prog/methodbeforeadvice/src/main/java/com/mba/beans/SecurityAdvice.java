package com.mba.beans;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

import com.mba.helper.SecurityManager;

public class SecurityAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		SecurityManager securityManager = SecurityManager.getInstance();
		if (securityManager.authenticate() == false) {
			throw new IllegalArgumentException("invalid username/password");
		}
	}

}
