package com.ehc.controller;

import com.ehc.event.ReloadCacheApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class CityController implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher applicationEventPublisher;

    public int addCity(String cityName) {
        int cityNo = 0;
        cityNo = new SecureRandom().nextInt(100);
        System.out.println("added city into the database...");

        // publish the event, for reloading the data into the cache
        ReloadCacheApplicationEvent event = new ReloadCacheApplicationEvent(this, "cities");
        applicationEventPublisher.publishEvent(event);

        return cityNo;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
