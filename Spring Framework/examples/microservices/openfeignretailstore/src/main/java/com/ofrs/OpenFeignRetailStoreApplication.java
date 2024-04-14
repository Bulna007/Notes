package com.ofrs;

import com.ofrs.dto.DistributorDto;
import com.ofrs.service.DistributorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OpenFeignRetailStoreApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(OpenFeignRetailStoreApplication.class);

        DistributorService distributorService = applicationContext.getBean( DistributorService.class);
        DistributorDto dto = distributorService.getDistributor("D001");
        System.out.println(dto);
    }
}
