package com.aa.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

import com.aa.helper.Cache;

public class CacheAspect {
	private Cache cache;

	public Object doCache(ProceedingJoinPoint pjp) throws Throwable {
		String methodName = null;
		Object[] args = null;
		String key = null;
		Object ret = null;

		methodName = pjp.getSignature().getName();
		args = pjp.getArgs();
		key = methodName + "(" + args[0] + "," + args[1] + ")";
		if (cache.containsKey(key)) {
			ret = cache.get(key);
			return ret;
		}
		ret = pjp.proceed();
		cache.put(key, ret);

		return ret;
	}

	public void setCache(Cache cache) {
		this.cache = cache;
	}

}
