package com.ta.aspect;

import org.aspectj.lang.JoinPoint;

public class GlobalExceptionLoggingAspect {

	public void logException(JoinPoint jp, IllegalArgumentException iae) {
		System.out.println(jp.getSignature().getName() + "(" + jp.getArgs()[0]
				+ ") has reported an exception with message :" + iae.getMessage());
	}

}
