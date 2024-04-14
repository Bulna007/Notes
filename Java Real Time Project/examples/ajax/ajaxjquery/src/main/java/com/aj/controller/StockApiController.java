package com.aj.controller;

import com.aj.dto.StockDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.SecureRandom;

@RestController
@RequestMapping("/stock")
public class StockApiController {

    @GetMapping(value = "/{stockName}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public StockDto getStock(@PathVariable("stockName") String stockName) {
        SecureRandom random = new SecureRandom();
        StockDto dto = null;

        dto = StockDto.of().stockName(stockName)
                .price(random.nextDouble(500))
                ._52WeekLow(random.nextDouble(300))
                ._52WeekHigh(1000).build();

        return dto;
    }
}
