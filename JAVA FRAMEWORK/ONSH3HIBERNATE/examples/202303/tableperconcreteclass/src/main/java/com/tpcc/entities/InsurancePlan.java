package com.tpcc.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "insurance_plan")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@TableGenerator(name = "planNoTblGen", table = "unique_keys_table", pkColumnName = "pkName", valueColumnName = "pkValue", pkColumnValue = "plan_no", allocationSize = 1)
public class InsurancePlan implements Serializable {
    @Id
    @Column(name = "plan_no")
    @GeneratedValue(generator = "planNoTblGen")
    protected int planNo;
    @Column(name = "plan_nm")
    protected String planName;
    protected int tenure;
    @Column(name = "premium_amt")
    protected double premiumAmount;
    @Column(name = "insurred_amt")
    protected double insurredAmount;
    protected String status;

    public int getPlanNo() {
        return planNo;
    }

    public void setPlanNo(int planNo) {
        this.planNo = planNo;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public int getTenure() {
        return tenure;
    }

    public void setTenure(int tenure) {
        this.tenure = tenure;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(double premiumAmount) {
        this.premiumAmount = premiumAmount;
    }

    public double getInsurredAmount() {
        return insurredAmount;
    }

    public void setInsurredAmount(double insurredAmount) {
        this.insurredAmount = insurredAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InsurancePlan that)) return false;
        return getPlanNo() == that.getPlanNo() && getTenure() == that.getTenure() && Double.compare(that.getPremiumAmount(), getPremiumAmount()) == 0 && Double.compare(that.getInsurredAmount(), getInsurredAmount()) == 0 && Objects.equals(getPlanName(), that.getPlanName()) && Objects.equals(getStatus(), that.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlanNo(), getPlanName(), getTenure(), getPremiumAmount(), getInsurredAmount(), getStatus());
    }

    @Override
    public String toString() {
        return "InsurancePlan{" +
                "planNo=" + planNo +
                ", planName='" + planName + '\'' +
                ", tenure=" + tenure +
                ", premiumAmount=" + premiumAmount +
                ", insurredAmount=" + insurredAmount +
                ", status='" + status + '\'' +
                '}';
    }
}
