package com.hbs.boot;

import com.hbs.api.AccountApiService;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Application;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class HttpBasicSecurityApplication extends Application {
    private Set<Class<?>> classes;

    public HttpBasicSecurityApplication() {
        classes = new HashSet<>();
        classes.add(AccountApiService.class);
        classes.add(RolesAllowedDynamicFeature.class);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }
}
