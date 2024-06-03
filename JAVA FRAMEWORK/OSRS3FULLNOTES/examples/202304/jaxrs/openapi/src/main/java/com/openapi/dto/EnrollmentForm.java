package com.openapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "of")
public class EnrollmentForm {
    private String customerName;
    private int age;
    private String gender;
    private int planNo;
    private int tenure;
    private double insurredAmount;
}
