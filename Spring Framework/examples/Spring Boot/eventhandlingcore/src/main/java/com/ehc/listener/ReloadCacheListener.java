package com.ehc.listener;

import com.ehc.event.ReloadCacheApplicationEvent;
import com.ehc.helper.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ReloadCacheListener implements ApplicationListener<ReloadCacheApplicationEvent> {
    @Autowired
    private CacheManager cacheManager;

    @Override
    public void onApplicationEvent(ReloadCacheApplicationEvent event) {
        cacheManager.reloadCache(event.getKey());
    }
}
