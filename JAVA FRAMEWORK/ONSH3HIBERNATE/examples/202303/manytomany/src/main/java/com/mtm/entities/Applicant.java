package com.mtm.entities;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
public class Applicant implements Serializable {
    private int applicantNo;
    private String applicantName;
    private int experience;
    private String qualification;
    private String gender;
    private int age;
    private Set<Job> appliedJobs;

}
