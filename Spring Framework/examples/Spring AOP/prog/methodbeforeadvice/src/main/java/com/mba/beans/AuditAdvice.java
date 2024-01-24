package com.mba.beans;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

import com.mba.helper.SecurityManager;

public class AuditAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		String methodName = null;
		SecurityManager securityManager = SecurityManager.getInstance();

		methodName = method.getName();
		System.out.print(methodName + "(");
		for (int i = 0; i < args.length; i++) {
			if (i == 0) {
				System.out.print(args[i]);
				continue;
			}
			System.out.print("," + args[i]);
		}
		System.out.println(") has been called by " + securityManager.getLoggedInUser());
	}

}
