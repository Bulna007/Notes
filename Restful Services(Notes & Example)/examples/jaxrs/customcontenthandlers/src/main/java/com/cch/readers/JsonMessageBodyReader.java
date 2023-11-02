package com.cch.readers;

import com.cch.dto.EnrollmentForm;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.ext.MessageBodyReader;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
@Consumes(MediaType.APPLICATION_JSON)
public class JsonMessageBodyReader implements MessageBodyReader<Object> {
    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        if (type == EnrollmentForm.class) {
            return true;
        }
        return false;
    }

    @Override
    public Object readFrom(Class<Object> type, Type genericType, Annotation[] annotations,
                           MediaType mediaType, MultivaluedMap<String, String> httpHeaders,
                           InputStream entityStream) throws IOException, WebApplicationException {
        Object obj = null;

        System.out.println("readFrom(..)");
        Jsonb jsonb = JsonbBuilder.create();
        obj = jsonb.fromJson(entityStream, type);

        return obj;
    }
}
