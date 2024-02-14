package com.bootcore;

import com.bootcore.beans.CreditReport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BootCoreApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BootCoreApplication.class);
        CreditReport report = context.getBean("creditReport", CreditReport.class);
        System.out.println(report);
    }
}
