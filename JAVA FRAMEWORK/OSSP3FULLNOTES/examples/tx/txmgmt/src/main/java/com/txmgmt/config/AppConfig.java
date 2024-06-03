package com.txmgmt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import({ PersistenceConfig.class })
@ComponentScan(basePackages = { "com.txmgmt.service", "com.txmgmt.controller" })
@EnableTransactionManagement
public class AppConfig {

}
