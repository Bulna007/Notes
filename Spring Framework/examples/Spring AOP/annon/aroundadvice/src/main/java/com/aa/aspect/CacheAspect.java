package com.aa.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.aa.helper.Cache;

@Component
@Order(1)
@Aspect
public class CacheAspect {
	@Autowired
	private Cache cache;

	@Around("execution(* com.aa.beans.*.*(..))")
	public Object doCache(ProceedingJoinPoint pjp) throws Throwable {
		String methodName = null;
		Object[] args = null;
		String key = null;

		methodName = pjp.getSignature().getName();
		args = pjp.getArgs();
		key = methodName + "(" + args[0] + "," + args[1] + ")";
		if (cache.containsKey(key)) {
			return cache.get(key);
		}
		Object ret = pjp.proceed();
		cache.put(key, ret);
		return ret;
	}
}
