package com.jbvc.test;

import com.jbvc.bean.LoanApplicationForm;
import com.jbvc.groups.DemographicGroup;
import com.jbvc.groups.LoanInfoGroup;
import com.jbvc.groups.Severity;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.time.LocalDate;
import java.util.Set;

public class LoanApplicationValidatorTest {
    public static void main(String[] args) {
        LoanApplicationForm form = LoanApplicationForm.of().firstName("Gabriel")
                .dob(LocalDate.now().plusDays(1))
                .gender("Male")
                .tenure(320)
                .loanAmount(10000)
                .build();
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Set<ConstraintViolation<LoanApplicationForm>> violations = validator.validate(form, LoanInfoGroup.class);

        violations.stream().filter(violation->{
            return violation.getConstraintDescriptor().getPayload().contains(Severity.Critical.class);
        }).forEach(violation->{
            System.out.println(violation.getMessage());
        });
    }
}
