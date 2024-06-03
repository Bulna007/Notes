package com.mtm.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "applicant")
@Data
public class Applicant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "applicant_no")
    private int applicantNo;
    @Column(name = "applicant_nm")
    private String applicantName;
    private int experience;
    private String qualification;
    private String gender;
    private int age;
    @ManyToMany
    @JoinTable(name = "job_applicants",
            joinColumns = {@JoinColumn(name = "applicant_no")},
            inverseJoinColumns = {@JoinColumn(name = "job_no")})
    private Set<Job> appliedJobs;

}
