package com.jbvc.test;

import com.jbvc.bean.Customer;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Set;

public class JBVTest {
    public static void main(String[] args) {
        Customer customer = Customer.of().firstName("Paul")
                .lastName("K")
                .age(10).gender("Male")
                .mobileNo("9845537839")
                .emailAddress("paul@gmail.com")
                .build();
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Set<ConstraintViolation<Customer>> constraintViolations = validator.validate(customer);
        constraintViolations.forEach(customerConstraintViolation -> {
            System.out.println(customerConstraintViolation.getMessage());
        });
    }
}
