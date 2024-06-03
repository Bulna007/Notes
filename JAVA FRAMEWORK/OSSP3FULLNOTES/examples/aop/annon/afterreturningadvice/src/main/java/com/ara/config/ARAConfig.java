package com.ara.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = { "com.ara.beans", "com.ara.aspect" })
@EnableAspectJAutoProxy
public class ARAConfig {

}
