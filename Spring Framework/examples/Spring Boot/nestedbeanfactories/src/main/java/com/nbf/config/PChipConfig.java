package com.nbf.config;

import com.nbf.beans.Chip;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PChipConfig {
    @Bean
    public Chip chip(@Value("${chipType}") String chipType) {
        Chip chip = new Chip();
        chip.setChipType(chipType);
        return chip;
    }
}
