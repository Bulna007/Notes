package com.ara.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class KeyValidatorAspect {

	@AfterReturning(value = "execution(* com.ara.beans.KeyGenerator.*(..))", returning = "ret")
	public void validate(JoinPoint jp, Object ret) throws Exception {
		if ((Integer) ret <= 0) {
			throw new Exception("Weak key generated");
		}
	}
}
