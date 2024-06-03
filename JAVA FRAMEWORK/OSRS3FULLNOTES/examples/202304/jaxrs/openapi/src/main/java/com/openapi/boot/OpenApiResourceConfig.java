package com.openapi.boot;

import com.openapi.api.PolicyApiService;
import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
public class OpenApiResourceConfig extends ResourceConfig {
    public OpenApiResourceConfig() {
        register(PolicyApiService.class);
        packages("io.swagger.v3.jaxrs2.integration");
    }
}
