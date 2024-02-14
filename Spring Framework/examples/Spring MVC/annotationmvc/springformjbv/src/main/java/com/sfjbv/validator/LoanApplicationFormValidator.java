package com.sfjbv.validator;

import com.sfjbv.form.LoanApplicationForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class LoanApplicationFormValidator implements Validator {
    private final String DB_EMAIL_ADDRESS = "tech.sriman@gmail.com";
    private final String DB_MOBILE_NO = "999999999999";

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(LoanApplicationForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LoanApplicationForm form = (LoanApplicationForm) target;

        if(errors.hasFieldErrors("emailAddress") == false) {
            // check whether the emailAddress, there is an existing application or not in db
            if(DB_EMAIL_ADDRESS.equals(form.getEmailAddress())) {
                errors.rejectValue("emailAddress", "emailAddress.alreadyExists");
            }
        }

        if(errors.hasFieldErrors("mobileNo")==false) {
            if(DB_MOBILE_NO.equals(form.getMobileNumber())) {
                errors.rejectValue("mobileNo", "mobileNo.alreadyExists");
            }
        }

    }
}
