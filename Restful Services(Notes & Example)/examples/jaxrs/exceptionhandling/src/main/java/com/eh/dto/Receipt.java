package com.eh.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(builderMethodName = "of")
@NoArgsConstructor
@AllArgsConstructor
public class Receipt {
    private String receiptNo;
    private String mobileNo;
    private double amount;
    private String status;

}
