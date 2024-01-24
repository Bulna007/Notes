package com.ta.beans;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class GlobalExceptionLoggingAdvice implements ThrowsAdvice {

//	public void afterThrowing(Method method, Object[] args, Object target, IllegalArgumentException e) {
//		System.out.print(method.getName() + "(");
//		for (int i = 0; i < args.length; i++) {
//			if (i == 0) {
//				System.out.print(args[i]);
//				continue;
//			}
//			System.out.print("," + args[i]);
//		}
//		System.out.println(" has thrown an exception with message : " + e.getMessage());
//	}

	public void afterThrowing(Throwable e) {
		System.out.println("(Throwable) throws an exception with message : " + e.getMessage());
	}

	public void afterThrowing(IllegalArgumentException e) {
		System.out.println("throws an exception with message : " + e.getMessage());
	}
}
