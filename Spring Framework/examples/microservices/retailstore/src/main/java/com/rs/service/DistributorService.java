package com.rs.service;

import com.rs.dto.DistributorDto;
import lombok.AllArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class DistributorService {
    private final RestTemplate restTemplate;
    private final DiscoveryClient discoveryClient;

    public DistributorDto getDistributor(String distributorCode) {
        DistributorDto dto = null;

        List<ServiceInstance> instances = discoveryClient.getInstances("distributor-network");
        ServiceInstance instance = instances.get(0);

        String host = instance.getHost();
        int port = instance.getPort();

        String endPointUri = "http://"+host + ":" + port + "/distributor/{distributorCode}";
        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("distributorCode", distributorCode);

        String url = UriComponentsBuilder.fromUriString(endPointUri).uriVariables(uriVariables).build().toString();
        dto = restTemplate.getForEntity(url, DistributorDto.class).getBody();

        return dto;
    }

}
