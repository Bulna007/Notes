package com.rsr4j;

import com.rsr4j.dto.DistributorDto;
import com.rsr4j.service.DistributorNetworkService;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@SpringBootApplication
@EnableDiscoveryClient
public class RetailStoreResilience4JApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(RetailStoreResilience4JApplication.class, args);
        DistributorNetworkService distributorNetworkService = context.getBean(DistributorNetworkService.class);
        DistributorDto dto = distributorNetworkService.getDistributor("D001");
        System.out.println(dto);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Customizer<Resilience4JCircuitBreakerFactory> resilience4JCircuitBreakerFactoryCustomizer() {
        return (resilience4JCircuitBreakerFactory) -> {
            resilience4JCircuitBreakerFactory.configure((resilience4JConfigBuilder -> {
                resilience4JConfigBuilder
                        .circuitBreakerConfig(CircuitBreakerConfig.custom()
                                .failureRateThreshold(3)
                                .waitDurationInOpenState(Duration.ofSeconds(2))
                                .slidingWindowSize(2).slowCallRateThreshold(3).build())
                        .timeLimiterConfig(TimeLimiterConfig.custom()
                                .timeoutDuration(Duration.ofSeconds(3)).build());
            }), "distributorNetwork");
            resilience4JCircuitBreakerFactory.configure((resilience4JConfigBuilder -> {
                resilience4JConfigBuilder
                        .circuitBreakerConfig(CircuitBreakerConfig.custom()
                                .failureRateThreshold(3)
                                .waitDurationInOpenState(Duration.ofSeconds(1))
                                .slidingWindowSize(2).slowCallRateThreshold(2).build())
                        .timeLimiterConfig(TimeLimiterConfig.custom()
                                .timeoutDuration(Duration.ofSeconds(2)).build());
            }), "inventoryManagement");
        };
    }
}
