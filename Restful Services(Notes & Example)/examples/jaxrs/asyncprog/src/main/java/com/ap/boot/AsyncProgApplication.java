package com.ap.boot;

import com.ap.api.OrderApiService;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class AsyncProgApplication extends ResourceConfig {
    public AsyncProgApplication() {
        super.register(JacksonFeature.class);
        register(OrderApiService.class);
    }
}
