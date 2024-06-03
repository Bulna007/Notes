package com.wfapi.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderMethodName = "of")
public class StudentDto {
    private int no;
    private String name;
    private String mobile;
    private String emailAddress;

}
