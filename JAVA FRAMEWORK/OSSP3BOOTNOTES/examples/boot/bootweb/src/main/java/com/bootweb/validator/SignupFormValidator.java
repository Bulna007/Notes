package com.bootweb.validator;

import com.bootweb.form.SignupForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SignupFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(SignupForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SignupForm signupForm = (SignupForm) target;

        if(errors.hasFieldErrors("password") == false && errors.hasFieldErrors("reTypePassword")==false) {
            if(signupForm.getPassword().equals(signupForm.getReTypePassword()) == false) {
                errors.rejectValue("reTypePassword", "password.mismatch");
            }
        }
    }
}
