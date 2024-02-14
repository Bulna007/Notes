package com.sfjbv.formatter.factory;

import com.sfjbv.formatter.MobileNumberFormatter;
import com.sfjbv.formatter.annotation.MobileNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Parser;
import org.springframework.format.Printer;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class MobileNumberAnnotationFormatterFactory implements AnnotationFormatterFactory<MobileNumber> {
    @Autowired
    private MobileNumberFormatter mobileNumberFormatter;

    @Override
    public Set<Class<?>> getFieldTypes() {
        return new HashSet<>(Arrays.asList(com.sfjbv.form.MobileNumber.class));
    }

    @Override
    public Printer<?> getPrinter(MobileNumber annotation, Class<?> fieldType) {
        return mobileNumberFormatter;
    }

    @Override
    public Parser<?> getParser(MobileNumber annotation, Class<?> fieldType) {
        return mobileNumberFormatter;
    }
}
