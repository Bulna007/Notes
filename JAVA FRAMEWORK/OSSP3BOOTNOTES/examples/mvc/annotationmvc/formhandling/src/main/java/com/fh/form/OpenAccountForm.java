package com.fh.form;

import lombok.Data;

@Data
public class OpenAccountForm {
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String identityType;
    private String identityNo;
    private String accountType;

}
