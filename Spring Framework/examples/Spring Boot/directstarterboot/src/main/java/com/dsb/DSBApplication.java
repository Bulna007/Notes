package com.dsb;

import com.dsb.beans.Radio;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DSBApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DSBApplication.class);
        Radio radio = context.getBean("radio", Radio.class);
        radio.play();
    }
}
