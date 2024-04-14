package com.sjpa.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "project")
@NamedQueries({@NamedQuery(name = "getProjectsByDuration", query = "from Project p where p.duration >= :duration")})
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_no")
    private int projectNo;
    @Column(name = "project_nm")
    private String projectName;
    @Column(name = "client_nm")
    private String clientName;
    private int duration;
    @Column(name = "team_size")
    private int teamSize;
    @Column(name = "start_dt")
    private LocalDate startDate;

}
