package com.callassist;

import com.callassist.service.CallAssistService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CallAssistApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(CallAssistApplication.class);
        CallAssistService assistService = applicationContext.getBean("callAssistService", CallAssistService.class);
        assistService.call("92839303494");
    }
}
