package com.kkart.dto;

import lombok.Data;

@Data
public class OrderDto {
    private String customerName;
    private int quantity;
    private double amount;
}
