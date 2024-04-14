package com.inventorymgmt.service;

import com.inventorymgmt.dto.Stock;
import com.inventorymgmt.exception.NotFoundException;
import com.inventorymgmt.repositories.StockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class StockService {
    private final StockRepository stockRepository;

    @Transactional(readOnly = true)
    public Stock getStock(String modelNo) {
        return stockRepository.findByModelNo(modelNo).stream().map(e ->
                Stock.of().stockName(e.getProductName())
                        .modelNo(e.getModelNo())
                        .quantity(e.getQuantity())
                        .price(e.getPrice()).build()
        ).findFirst().orElseThrow(() -> {
            throw new NotFoundException("Stock Not Available");
        });
    }
}
