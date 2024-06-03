package com.tpch.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
@DiscriminatorValue("MedicalInsurancePlan")
public class MedicalInsurancePlan extends InsurancePlan {
    private int copay;
    @Column(name="coverage_type")
    private String coverageType;

    public int getCopay() {
        return copay;
    }

    public void setCopay(int copay) {
        this.copay = copay;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public void setCoverageType(String coverageType) {
        this.coverageType = coverageType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MedicalInsurancePlan that)) return false;
        if (!super.equals(o)) return false;
        return getCopay() == that.getCopay() && Objects.equals(getCoverageType(), that.getCoverageType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCopay(), getCoverageType());
    }

    @Override
    public String toString() {
        return "MedicalInsurancePlan{" +
                "copay=" + copay +
                ", coverageType='" + coverageType + '\'' +
                ", planNo=" + planNo +
                ", planName='" + planName + '\'' +
                ", tenure=" + tenure +
                ", premiumAmount=" + premiumAmount +
                ", insurredAmount=" + insurredAmount +
                ", status='" + status + '\'' +
                '}';
    }
}
