package com.mba.aspect;

import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;

import com.mba.helper.SecurityManager;

// improves the code organizing
public class SecurityAspect {
	private SecurityManager securityManager;

	public void doAudit(JoinPoint jp) {
		String methodName = null;
		Object[] args = null;

		methodName = jp.getSignature().getName();
		args = jp.getArgs();

		System.out.println(methodName + "(" + args[0] + ") invoked by " + securityManager.loggedInUser() + " at : "
				+ LocalDateTime.now());
	}

	public void authenticate(JoinPoint jp) throws Throwable {
		if (securityManager.authenticate() == false) {
			throw new IllegalAccessException("invalid un/pwd");
		}
	}

	public void setSecurityManager(SecurityManager securityManager) {
		this.securityManager = securityManager;
	}

}
