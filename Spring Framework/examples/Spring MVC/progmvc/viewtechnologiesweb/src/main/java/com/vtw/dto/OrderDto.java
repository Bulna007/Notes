package com.vtw.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "of")
public class OrderDto {
    private String orderNo;
    private LocalDate orderPlacedDate;
    private int quantity;
    private String status;
    private double amount;

}
