package com.ara.aspect;

import org.aspectj.lang.JoinPoint;

public class KeyValidatorAspect {

	public void validateKey(JoinPoint jp, Object ret) throws Exception {
		if ((Integer) ret <= 0) {
			throw new Exception("weak key generated");
		}
	}
}
