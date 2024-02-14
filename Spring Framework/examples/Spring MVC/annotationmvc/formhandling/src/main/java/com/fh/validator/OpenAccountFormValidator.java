package com.fh.validator;

import com.fh.form.OpenAccountForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class OpenAccountFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(OpenAccountForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        OpenAccountForm form = (OpenAccountForm) target;

        if (form.getFirstName() == null || form.getFirstName().trim().length() == 0) {
            errors.rejectValue("firstName", "firstName.blank");
        }
        if (form.getLastName() == null || form.getLastName().trim().length() == 0) {
            errors.rejectValue("lastName", "lastName.blank");
        }
        if(errors.hasFieldErrors("age") == false) {
            if(form.getAge() < 0 || form.getAge() > 100) {
                errors.rejectValue("age", "age.invalidRange");
            }
        }
        if(form.getGender() == null || form.getGender().trim().length() == 0) {
            errors.rejectValue("gender", "gender.blank");
        }
        if(form.getIdentityNo() == null || form.getIdentityNo().trim().length() == 0) {
            errors.rejectValue("identityNo", "identityNo.blank");
        }
    }
}
