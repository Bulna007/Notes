package com.jh.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "profession")
@Data
public class Profession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profession_id")
    private int professionId;
    @Column(name = "profession_nm")
    private String professionName;
}
