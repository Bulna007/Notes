package com.bootweb.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class SignupForm {
    @Email
    private String emailAddress;
    @NotBlank
    private String password;
    @NotBlank
    private String reTypePassword;
    @NotBlank
    private String fullname;
    @NotBlank
    private String gender;
    @Range(min = 18, max = 100)
    private int age;
}
