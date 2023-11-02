package com.cch.readers;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.ext.MessageBodyReader;
import jakarta.ws.rs.ext.Provider;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
@Consumes(MediaType.APPLICATION_XML)
public class JAXBMessageBodyReader implements MessageBodyReader<Object> {
    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        if(type.isAnnotationPresent(XmlRootElement.class)) {
            return true;
        }
        return false;
    }

    @Override
    public Object readFrom(Class<Object> type, Type genericType, Annotation[] annotations,
                           MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException, WebApplicationException {
        Unmarshaller unmarshaller = null;
        JAXBContext jaxbContext = null;
        Object object = null;
        try {
            jaxbContext = JAXBContext.newInstance(type);
            unmarshaller = jaxbContext.createUnmarshaller();
            object = unmarshaller.unmarshal(entityStream);
        } catch (JAXBException e) {
            throw new WebApplicationException(e);
        }

        return object;
    }
}
