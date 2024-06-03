package com.sr.boot;

import com.sr.api.DoctorApiService;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.glassfish.jersey.jackson.JacksonFeature;

import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class ServerResponseApplication extends Application {
    private Set<Class<?>> classes;

    public ServerResponseApplication() {
        classes = new HashSet<>();
        classes.add(DoctorApiService.class);
        classes.add(JacksonFeature.class);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }
}
