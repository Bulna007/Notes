package com.jbvc.annotation;

import com.jbvc.validator.PhoneNumberConstraintValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Documented
@Constraint(validatedBy = PhoneNumberConstraintValidator.class)
public @interface PhoneNumber {
    String message() default "Phone Number is not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
