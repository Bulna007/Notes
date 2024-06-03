package com.cch.boot;

import com.cch.api.PolicyApiService;
import com.cch.readers.JAXBMessageBodyReader;
import com.cch.readers.JsonMessageBodyReader;
import com.cch.writers.JAXBMessageBodyWriter;
import com.cch.writers.JsonMessageBodyWriter;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJsonProvider;

import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class CCHApplication extends Application {
    private Set<Class<?>> classes;

    public CCHApplication() {
        classes = new HashSet<>();
        classes.add(PolicyApiService.class);
        //classes.add(JsonMessageBodyReader.class);
        //classes.add(JsonMessageBodyWriter.class);
        classes.add(JacksonFeature.class);
        classes.add(JAXBMessageBodyReader.class);
        classes.add(JAXBMessageBodyWriter.class);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }
}
