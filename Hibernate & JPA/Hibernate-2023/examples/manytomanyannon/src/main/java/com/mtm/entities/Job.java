package com.mtm.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "job")
@Data
public class Job implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "job_no")
    private int jobNo;
    @Column(name = "job_title")
    private String jobTitle;
    private String description;
    private int experience;
    private String qualification;
    private String company;

}
