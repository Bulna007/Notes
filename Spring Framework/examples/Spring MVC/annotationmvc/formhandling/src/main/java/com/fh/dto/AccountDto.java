package com.fh.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderMethodName = "of")
public class AccountDto {
    private String accountNo;
    private String accountHolderName;
    private String branchName;
    private String ifscCode;
    private String status;
}
