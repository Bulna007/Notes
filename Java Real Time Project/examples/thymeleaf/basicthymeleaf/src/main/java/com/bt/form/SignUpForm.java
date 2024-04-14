package com.bt.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jdk.jfr.DataAmount;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SignUpForm {
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotNull
    @Past
    private LocalDate dob;
    @NotEmpty
    private String gender;

}
