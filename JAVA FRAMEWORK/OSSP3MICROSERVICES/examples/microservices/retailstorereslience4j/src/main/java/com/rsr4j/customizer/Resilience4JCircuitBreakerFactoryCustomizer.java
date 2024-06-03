package com.rsr4j.customizer;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.function.Consumer;

//@Component
public class Resilience4JCircuitBreakerFactoryCustomizer implements Customizer<Resilience4JCircuitBreakerFactory> {
    @Override
    public void customize(Resilience4JCircuitBreakerFactory resilience4JCircuitBreakerFactory) {
        resilience4JCircuitBreakerFactory.configure(new DistributorNetworkResilience4JConfigBuilderConsumer(), "distributorNetwork");
        resilience4JCircuitBreakerFactory.configure(new InventoryMgmtResilience4JConfigBuilderConsumer(), "inventoryManagement");
    }

    private final class DistributorNetworkResilience4JConfigBuilderConsumer implements Consumer<Resilience4JConfigBuilder> {
        @Override
        public void accept(Resilience4JConfigBuilder resilience4JConfigBuilder) {
            resilience4JConfigBuilder
                    .circuitBreakerConfig(CircuitBreakerConfig.custom()
                            .failureRateThreshold(3)
                            .waitDurationInOpenState(Duration.ofSeconds(2))
                            .slidingWindowSize(2).slowCallRateThreshold(3).build())
                    .timeLimiterConfig(TimeLimiterConfig.custom()
                            .timeoutDuration(Duration.ofSeconds(3)).build());
        }
    }

    private final class InventoryMgmtResilience4JConfigBuilderConsumer implements Consumer<Resilience4JConfigBuilder> {
        @Override
        public void accept(Resilience4JConfigBuilder resilience4JConfigBuilder) {
            resilience4JConfigBuilder
                    .circuitBreakerConfig(CircuitBreakerConfig.custom()
                            .failureRateThreshold(3)
                            .waitDurationInOpenState(Duration.ofSeconds(1))
                            .slidingWindowSize(2).slowCallRateThreshold(2).build())
                    .timeLimiterConfig(TimeLimiterConfig.custom()
                            .timeoutDuration(Duration.ofSeconds(2)).build());
        }
    }

}




