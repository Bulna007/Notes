package com.jbvc.validator;

import com.jbvc.annotation.PhoneNumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberConstraintValidator implements ConstraintValidator<PhoneNumber, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.length() < 10 || value.length() > 12) {
            return false;
        }
        return value.chars().allMatch(ch -> Character.isDigit(ch));
    }

    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
