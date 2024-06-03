package com.oauth2phonepe.dto;

import lombok.Data;

@Data
public class MerchantPayment {
    private String phonePeAccountNo;
    private String merchantAccountNo;
    private double amount;
    private String remarks;
}
