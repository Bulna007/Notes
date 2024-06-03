package com.i18n.test;

import com.i18n.config.JavaConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Locale;

public class I18NTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        String header = context.getMessage("home.header", null, new Locale("hi", "IN"));
        System.out.println(header);

        String blankFieldMessage = context.getMessage("field.blank", new Object[]{"gender"}, Locale.getDefault());
        System.out.println(blankFieldMessage);
    }
}
