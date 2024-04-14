package com.scl;

import com.scl.dto.DistributorDto;
import com.scl.service.DistributorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SCLApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SCLApplication.class, args);
        DistributorService distributorService = context.getBean(DistributorService.class);

        DistributorDto dto = distributorService.getDistributor("D001");
        System.out.println(dto);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
