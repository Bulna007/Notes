package com.jh.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "specialization")
@Data
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specialization_id")
    private int specializationId;
    @Column(name = "specialization_nm")
    private String specializationName;

    @ManyToOne
    @JoinColumn(name = "profession_id")
    private Profession profession;


}
