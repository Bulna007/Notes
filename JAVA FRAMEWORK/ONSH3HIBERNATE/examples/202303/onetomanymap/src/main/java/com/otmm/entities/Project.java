package com.otmm.entities;

import java.io.Serializable;
import java.util.Objects;

public class Project implements Serializable {
    private int projectNo;
    private String description;
    private String workType;
    private int estimatedDays;
    private double estimatedAmount;

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public int getEstimatedDays() {
        return estimatedDays;
    }

    public void setEstimatedDays(int estimatedDays) {
        this.estimatedDays = estimatedDays;
    }

    public double getEstimatedAmount() {
        return estimatedAmount;
    }

    public void setEstimatedAmount(double estimatedAmount) {
        this.estimatedAmount = estimatedAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project project)) return false;
        return getEstimatedDays() == project.getEstimatedDays() && getDescription().equals(project.getDescription()) && getWorkType().equals(project.getWorkType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription(), getWorkType(), getEstimatedDays());
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectNo=" + projectNo +
                ", description='" + description + '\'' +
                ", workType='" + workType + '\'' +
                ", estimatedDays=" + estimatedDays +
                ", estimatedAmount=" + estimatedAmount +
                '}';
    }
}
