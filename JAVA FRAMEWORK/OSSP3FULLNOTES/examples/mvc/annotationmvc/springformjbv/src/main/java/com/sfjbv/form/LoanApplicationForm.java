package com.sfjbv.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
public class LoanApplicationForm {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @Past
    @DateTimeFormat(pattern = "MM/dd/YYYY")
    private Date dob;
    @NotBlank
    private String gender;

    //@Pattern(regexp = "\\d{12}")
    @com.sfjbv.formatter.annotation.MobileNumber
    private MobileNumber mobileNumber;
    @Email
    private String emailAddress;
    @NotBlank
    private String loanType;
    @Range(min = 12, max = 360)
    private int tenure;
    @Min(value = 50000)
    private double loanAmount;
}
