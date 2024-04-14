package com.aa.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {
	public Object log(ProceedingJoinPoint pjp) throws Throwable {
		String methodName = null;
		Object[] args = null;

		methodName = pjp.getSignature().getName();
		args = pjp.getArgs();

		System.out.println("entered into " + methodName + "(" + args[0] + "," + args[1] + ")");
		Object ret = pjp.proceed();
		System.out.println("exiting from " + methodName + " with ret :" + ret);
		return ret;
	}
}
