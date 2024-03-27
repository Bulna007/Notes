package com.bwjpa.actuator.endpoints;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component("info")
public class NBInfoEndpoint implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("application", "ibanking")
                .withDetail("version", "3.0")
                .withDetail("releaseNotes", "upgraded to jdk17")
                .build();
    }
}
