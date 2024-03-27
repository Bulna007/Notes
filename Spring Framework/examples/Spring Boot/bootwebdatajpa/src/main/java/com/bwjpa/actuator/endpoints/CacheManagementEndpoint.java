package com.bwjpa.actuator.endpoints;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

@Endpoint(id = "cachemanager", enableByDefault = false)
@Component
public class CacheManagementEndpoint {
    @DeleteOperation
    public int evict() {
        System.out.println("evicting the cache entries!!!");
        return new SecureRandom().nextInt(1000);
    }

    @ReadOperation
    public Map<String, String> metrics() {
        Map<String, String> metrics = new HashMap<>();
        metrics.put("maxEntries","100");
        metrics.put("evictionPolicy", "LRU");
        metrics.put("TTL", "30 seconds");

        return metrics;
    }
}
