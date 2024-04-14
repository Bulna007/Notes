package com.tpch.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
@DiscriminatorValue("AccidentalInsurancePlan")
public class AccidentalInsurancePlan extends InsurancePlan {
    @Column(name="disability_coverage_percentage")
    private int disabilityCoveragePercentage;
    @Column(name="international_coverage")
    private boolean internationalCoverage;

    public int getDisabilityCoveragePercentage() {
        return disabilityCoveragePercentage;
    }

    public void setDisabilityCoveragePercentage(int disabilityCoveragePercentage) {
        this.disabilityCoveragePercentage = disabilityCoveragePercentage;
    }

    public boolean getInternationalCoverage() {
        return internationalCoverage;
    }

    public void setInternationalCoverage(boolean internationalCoverage) {
        this.internationalCoverage = internationalCoverage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccidentalInsurancePlan that)) return false;
        if (!super.equals(o)) return false;
        return getDisabilityCoveragePercentage() == that.getDisabilityCoveragePercentage() && getInternationalCoverage() == that.getInternationalCoverage();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDisabilityCoveragePercentage(), getInternationalCoverage());
    }

    @Override
    public String toString() {
        return "AccidentalInsurancePlan{" +
                "disabilityCoveragePercentage=" + disabilityCoveragePercentage +
                ", internationalCoverage=" + internationalCoverage +
                ", planNo=" + planNo +
                ", planName='" + planName + '\'' +
                ", tenure=" + tenure +
                ", premiumAmount=" + premiumAmount +
                ", insurredAmount=" + insurredAmount +
                ", status='" + status + '\'' +
                '}';
    }
}
