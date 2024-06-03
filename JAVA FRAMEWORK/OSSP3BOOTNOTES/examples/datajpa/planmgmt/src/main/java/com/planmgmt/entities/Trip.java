package com.planmgmt.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "trip")
@Data
@NoArgsConstructor
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trip_no")
    private int tripNo;
    @Column(name = "trip_nm")
    private String tripName;
    private int days;
    @Column(name = "start_dt")
    private LocalDate startDate;
    @Column(name = "end_dt")
    private LocalDate endDate;
    @Column(name = "trip_cost")
    private double tripCost;
    private String source;
    private String destination;
}
