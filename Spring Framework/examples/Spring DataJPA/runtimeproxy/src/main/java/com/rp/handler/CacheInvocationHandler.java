package com.rp.handler;

import com.rp.helper.Cache;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// equalTo Proxy
public class CacheInvocationHandler implements InvocationHandler {
    private Object target;

    public CacheInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Cache cache = null;
        String key = null;
        Object ret = null;

        cache = Cache.getInstance();
        key = method.getName() + "(";
        for (int i = 0; i < args.length; i++) {
            if (i == 0) {
                key += args[i];
                continue;
            }
            key += "," + args[i];
        }
        if (cache.containsKey(key)) {
            return cache.get(key);
        } else {
            ret = method.invoke(target, args); // original class method
            cache.put(key, ret);
        }

        return ret;
    }
}
