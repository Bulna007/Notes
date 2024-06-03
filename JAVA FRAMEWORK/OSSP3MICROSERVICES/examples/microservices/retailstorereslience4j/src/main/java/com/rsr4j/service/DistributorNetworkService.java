package com.rsr4j.service;

import com.rsr4j.dto.DistributorDto;
import lombok.AllArgsConstructor;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Component
@AllArgsConstructor
public class DistributorNetworkService {
    private final String ROOT_RESOURCE_URI = "http://distributor-network/distributor";

    private final RestTemplate restTemplate;
    private final CircuitBreakerFactory circuitBreakerFactory;

    public DistributorDto getDistributor(final String distributorCode) {
        CircuitBreaker circuitBreaker = null;

        circuitBreaker = circuitBreakerFactory.create("distributorNetwork");

        DistributorDto dto = circuitBreaker.run(() -> {
            Map<String, Object> uriVariables = new HashMap<>();
            uriVariables.put("distributorCode", distributorCode);

            String url = UriComponentsBuilder.fromUriString(ROOT_RESOURCE_URI + "/{distributorCode}")
                    .uriVariables(uriVariables).build().toString();
            return restTemplate.getForObject(url, DistributorDto.class);
        });


        return dto;
    }
}
