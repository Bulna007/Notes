package com.ehc.event;

import org.springframework.context.ApplicationEvent;

public class ReloadCacheApplicationEvent extends ApplicationEvent {
    private String key;

    public ReloadCacheApplicationEvent(Object source, String key) {
        super(source);
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}

