package com.sr.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderMethodName = "of")
public class DoctorDto {
    private int doctorNo;
    private String doctorName;
    private int age;
    private String gender;
    private String mobileNo;
    private String emailAddress;
    private String qualification;
    private int experience;
    private String specialization;


}
