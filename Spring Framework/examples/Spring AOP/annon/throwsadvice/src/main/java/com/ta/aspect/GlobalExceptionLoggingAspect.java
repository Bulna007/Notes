package com.ta.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class GlobalExceptionLoggingAspect {

	@AfterThrowing(value = "within(com.ta.beans.*)", throwing = "iae")
	public void logException(JoinPoint jp, IllegalArgumentException iae) {
		System.out.println(jp.getSignature().getName() + "(" + jp.getArgs()[0]
				+ ") has reported an exception with message : " + iae.getMessage());
	}
}
