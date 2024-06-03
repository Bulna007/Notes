package com.jbvc.bean;

import com.jbvc.annotation.PhoneNumber;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
@Builder(builderMethodName = "of")
public class Customer {
    @NotBlank(message = "firstName cannot be blank")
    private String firstName;
    @NotBlank(message = "lastName cannot be blank")
    private String lastName;
    @Range(min = 1, max = 100, message = "age should be between 1 to 100")
    private int age;
    @Pattern(regexp = "Male|Female", message = "Gender can be either Male or Female only")
    private String gender;
    //@Pattern(regexp = "\\d{10}", message = "Mobile Number is not valid")
    @PhoneNumber(message = "Phone Number must be between 10 to 12 digits only")
    private String mobileNo;
    @Email(message = "Email Address is not valid")
    private String emailAddress;

}
