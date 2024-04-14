package com.aj.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderMethodName = "of")
public class StockDto {
    private String stockName;
    private double price;
    private double _52WeekLow;
    private double _52WeekHigh;


}
