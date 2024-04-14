package com.rp.test;

import com.rp.handler.CacheInvocationHandler;
import com.rp.service.NetbankingService;
import com.rp.service.NetbankingServiceImpl;

import java.lang.reflect.Proxy;

public class RuntimeProxyTest {
    public static void main(String[] args) {
        NetbankingService netbankingService = new NetbankingServiceImpl();
        CacheInvocationHandler handler = new CacheInvocationHandler(netbankingService);

        NetbankingService proxy = (NetbankingService) Proxy.newProxyInstance(NetbankingService.class.getClassLoader(),
                new Class[]{NetbankingService.class},
                handler);

        double balance = proxy.getBalance("ac1001");
        balance = proxy.getBalance("ac1001");


    }
}
