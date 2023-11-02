package com.openapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "of")
public class PolicyDetails {
    private String policyNo;
    private String planName;
    private String policyHolderName;
    private LocalDate effectiveDate;
    private LocalDate maturityDate;
    private double insurredAmount;
    private double premiumAmount;
}
