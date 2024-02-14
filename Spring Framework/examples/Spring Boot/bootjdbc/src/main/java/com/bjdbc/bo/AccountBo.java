package com.bjdbc.bo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderMethodName = "of")
public class AccountBo {
    private int accountNo;
    private String accountHolderName;
    private String accountType;
    private String ifscCode;
    private double balance;
}
