package com.oauth2phonepe.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder(builderMethodName = "of")
public class MerchantPaymentResponse {
    private String txNo;
    private LocalDate transactionDate;
    private String phonePeAccountNo;
    private String merchantAccountNo;
    private double amount;
    private String status;
}
