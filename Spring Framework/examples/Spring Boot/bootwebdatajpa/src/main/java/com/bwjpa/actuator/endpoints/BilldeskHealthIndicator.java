package com.bwjpa.actuator.endpoints;

import lombok.AllArgsConstructor;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component("billdesk")
@AllArgsConstructor
public class BilldeskHealthIndicator implements HealthIndicator {
    final private String BILL_DESK_HEALTH_CHECK_URL = "http://www.google.com";

    private final RestTemplate restTemplate;

    @Override
    public Health health() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(BILL_DESK_HEALTH_CHECK_URL, String.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            Health.Builder healthBuilder = Health.up();
            healthBuilder.withDetail("service", "billdesk").withDetail("responseTime", "100ms").up();
            return healthBuilder.build();
        }
        return Health.down().build();
    }
}
