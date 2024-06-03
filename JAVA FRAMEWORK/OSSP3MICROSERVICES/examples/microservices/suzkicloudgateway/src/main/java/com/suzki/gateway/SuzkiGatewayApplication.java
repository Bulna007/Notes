package com.suzki.gateway;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.Duration;

@SpringBootApplication
public class SuzkiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(SuzkiGatewayApplication.class, args);
    }

    @Bean
    public Customizer<Resilience4JCircuitBreakerFactory> resilience4JCircuitBreakerFactoryCustomizer() {
        return (resilience4JCircuitBreakerFactory -> {
            resilience4JCircuitBreakerFactory.configure((resilience4JConfigBuilder -> {
                resilience4JConfigBuilder.circuitBreakerConfig(CircuitBreakerConfig.custom()
                                .failureRateThreshold(3).slidingWindowSize(2)
                                .waitDurationInOpenState(Duration.ofSeconds(2)).build())
                        .timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(2)).build());
            }), "distributor-network-cb");
        });
    }

    /*@Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("distributor-network", r ->
                        r.path("/distributor-network/**")
                                .filters(f -> f.rewritePath("/distributor-network/?(?<segment>.*)", "/$\\{segment}")
                                        .circuitBreaker(config -> config.setName("distributor-network-cb")))
                                .uri("lb:http://DISTRIBUTOR-NETWORK")).build();
    }*/
}
