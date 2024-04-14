package com.rc.boot;

import com.rc.api.ProductApiService;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class CacheApplication extends ResourceConfig {


    public CacheApplication() {
        register(new ProductApiService());
        register(JacksonFeature.class);
        packages("io.swagger.v3.jaxrs2.integration");
    }


}
