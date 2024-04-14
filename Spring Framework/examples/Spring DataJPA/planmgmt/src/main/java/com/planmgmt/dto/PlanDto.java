package com.planmgmt.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderMethodName = "of")
public class PlanDto {
    private int planNo;
    private String planName;
    private String description;
    private String planType;
    private String eligibilityCriteria;
}
