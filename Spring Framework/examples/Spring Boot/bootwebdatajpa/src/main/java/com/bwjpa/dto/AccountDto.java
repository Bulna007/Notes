package com.bwjpa.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderMethodName = "of")
public class AccountDto {
    private int accountNo;
    private String accountHolderName;
    private double balance;
}
