package com.eh.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(builderMethodName = "of")
@NoArgsConstructor
@AllArgsConstructor
public class RechargeInfo {
    private String mobileNo;
    private String provider;
    private String circle;
    private String plan;
    private double amount;

}
