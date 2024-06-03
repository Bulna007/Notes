package com.ehc.helper;

import org.springframework.stereotype.Component;

@Component
public class CacheManager {

    public void reloadCache(String key) {
        System.out.println("reloading data of key : " + key);
    }
}
