package com.aroundadvice.beans;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.aroundadvice.helper.Cache;

public class CacheAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		String methodName = null;
		Object[] args = null;
		Cache cache = null;
		String key = null;
		Object ret = null;

		methodName = invocation.getMethod().getName();
		args = invocation.getArguments();
		key = methodName + "(";
		for (int i = 0; i < args.length; i++) {
			if (i == 0) {
				key += args[i];
				continue;
			}
			key += "," + args[i];
		}
		key += ")";

		cache = Cache.getInstance();
		if (cache.containsKey(key)) {
			ret = cache.get(key);
			return ret;
		}

		ret = invocation.proceed();
		cache.put(key, ret);

		return ret;
	}

}
