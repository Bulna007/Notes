package com.mba.aspect;

import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mba.helper.SecurityManager;

@Component
@Aspect
public class SecurityAspect {
	@Autowired
	private SecurityManager securityManager;

	@Pointcut("within(com.mba.beans.*)")
	public void securityPointcut() {
	}

	@Before("securityPointcut()")
	public void audit(JoinPoint jp) {
		System.out.println(jp.getSignature().getName() + " has been invoked by " + securityManager.loggedInUser()
				+ " at : " + LocalDateTime.now().toString());
	}

	@Before("securityPointcut()")
	public void checkSecurity(JoinPoint jp) throws IllegalAccessException {
		if (securityManager.authenticate() == false) {
			throw new IllegalAccessException("invalid un/pwd");
		}
	}
}
