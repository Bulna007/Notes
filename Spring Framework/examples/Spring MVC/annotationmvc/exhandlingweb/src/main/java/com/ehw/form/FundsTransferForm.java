package com.ehw.form;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class FundsTransferForm {
    @NotBlank
    @Length(min = 12, max = 12)
    private String fromAccount;
    @NotBlank
    @Length(min = 12, max = 12)
    private String toAccount;
    @Min(value = 1)
    @Max(value = 1000000)
    private double amount;
    @NotBlank
    private String transferType;
    @NotBlank
    private String remarks;

}
