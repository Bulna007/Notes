package com.bjdbc;

import com.bjdbc.service.AccountService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BJDBCApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(BJDBCApplication.class, args);
        AccountService accountService = applicationContext.getBean(AccountService.class);
        accountService.getAllAccounts().forEach(System.out::println);
    }
}
