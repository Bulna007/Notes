package com.aa.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class LoggingAspect {

	@Around("execution(* com.aa.beans.*.*(..))")
	public Object log(ProceedingJoinPoint pjp) throws Throwable {
		String methodName = null;
		Object[] args = null;

		methodName = pjp.getSignature().getName();
		args = pjp.getArgs();

		System.out.println("entered into " + methodName + "(" + args[0] + "," + args[1] + ")");
		Object ret = pjp.proceed();
		System.out.println("exiting from " + methodName + " with ret : " + ret);
		return ret;
	}
}
