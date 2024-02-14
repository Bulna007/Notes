package com.planmgmt.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "plan")
@Data
@NoArgsConstructor
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plan_no")
    private int planNo;
    @Column(name = "plan_nm")
    private String planName;
    private String description;
    @Column(name = "plan_type")
    private String planType;
    @Column(name = "eligibility_criteria")
    private String eligibilityCriteria;
}
