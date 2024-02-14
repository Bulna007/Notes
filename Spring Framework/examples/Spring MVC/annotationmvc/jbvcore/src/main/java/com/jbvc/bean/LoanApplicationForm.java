package com.jbvc.bean;

import com.jbvc.groups.DemographicGroup;
import com.jbvc.groups.LoanInfoGroup;
import com.jbvc.groups.Severity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;

@Data
@Builder(builderMethodName = "of")
public class LoanApplicationForm {
    @NotBlank(message = "firstName cannot be blank", groups = {DemographicGroup.class},
            payload = {Severity.Critical.class})
    private String firstName;
    @NotBlank(message = "lastName cannot be blank", groups = {DemographicGroup.class},
            payload = {Severity.Minor.class})
    private String lastName;
    @NotNull(message = "dob cannot be blank", groups = {DemographicGroup.class}, payload = {Severity.Critical.class})
    @Past(message = "dob should be in past", groups = {DemographicGroup.class}, payload = {Severity.Critical.class})
    private LocalDate dob;
    @NotBlank(message = "gender cannot be blank", groups = {DemographicGroup.class})
    private String gender;
    @NotBlank(message = "loanType cannot be blank", groups = {LoanInfoGroup.class},
            payload = Severity.Critical.class)
    private String loanType;
    @Min(value = 50000, message = "loanAmount should be greaterThan or equal to 50000", groups = {LoanInfoGroup.class},
            payload = {Severity.Critical.class})
    private double loanAmount;
    @Range(min = 12, max = 240, message = "tenure should be between 12 to 240 only", groups = {LoanInfoGroup.class},
            payload = {Severity.Critical.class})
    private int tenure;

}
