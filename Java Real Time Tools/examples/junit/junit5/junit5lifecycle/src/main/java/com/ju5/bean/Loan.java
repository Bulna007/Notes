package com.ju5.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Loan {
    double principle;
    int tenure;
    float ri;
}
