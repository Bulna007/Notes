package com.mto.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(builderMethodName = "of")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @Column(name = "task_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskNo;
    @Column(name = "task_nm")
    private String taskName;
    @Column(name = "story_points")
    private int storyPoints;
    @Column(name = "assigned_to")
    private String assignedTo;

    @ManyToOne
    @JoinColumn(name = "project_no")
    private Project project;
}
