package com.mto.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder(builderMethodName = "of")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "project")
public class Project implements Serializable {
    @Id
    @Column(name = "project_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectNo;
    private String title;
    @Column(name = "estimated_duration")
    private int estimatedDuration;
    @Column(name = "started_dt")
    private LocalDate startedDate;
    @Column(name = "client_nm")
    private String clientName;

}
