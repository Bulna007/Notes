package com.bt.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(builderMethodName = "of")
public class Product {
    String productName;
    String description;
    double price;
    int rating;
    List<String> features;
}
