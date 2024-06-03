package com.rc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(builderMethodName = "of")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String productNo;
    private String productName;
    private String description;
    private String manufacturer;
    private double price;
}
