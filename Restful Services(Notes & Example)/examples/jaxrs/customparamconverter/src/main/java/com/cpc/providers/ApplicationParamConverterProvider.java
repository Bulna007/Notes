package com.cpc.providers;

import com.cpc.dto.AccountNo;
import com.cpc.paramconverters.AccountNoParamConverter;
import jakarta.ws.rs.ext.ParamConverter;
import jakarta.ws.rs.ext.ParamConverterProvider;
import jakarta.ws.rs.ext.Provider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
public class ApplicationParamConverterProvider implements ParamConverterProvider {
    @Override
    public ParamConverter getConverter(Class rawType, Type genericType, Annotation[] annotations) {
        System.out.println("getConverter(" + rawType.getName() + ")");
        if (rawType == AccountNo.class) {
            return new AccountNoParamConverter();
        }
        return null;
    }
}
