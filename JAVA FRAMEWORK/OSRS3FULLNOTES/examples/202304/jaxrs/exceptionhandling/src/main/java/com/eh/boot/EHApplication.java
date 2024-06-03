package com.eh.boot;

import com.eh.api.MobileRechargeApiService;
import com.eh.exception.mapper.SubscriptionNotActiveExceptionMapper;
import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
public class EHApplication extends ResourceConfig {
    public EHApplication() {
        register(JacksonFeature.class);
        register(MobileRechargeApiService.class);
        register(SubscriptionNotActiveExceptionMapper.class);
    }
}
