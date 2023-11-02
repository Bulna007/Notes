package com.jsonbinding.bean;

import jakarta.json.bind.annotation.JsonbProperty;

public class Plan {
    @JsonbProperty("plan_no")
    private int planNo;
    @JsonbProperty("plan_name")
    private String planName;
    @JsonbProperty("plan_type")
    private String planType;
    private int tenure;
    @JsonbProperty("premium_amount")
    private double premiumAmount;
    @JsonbProperty("insurred_amount")
    private double insurredAmount;

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

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
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

    @Override
    public String toString() {
        return "Plan{" +
                "planNo=" + planNo +
                ", planName='" + planName + '\'' +
                ", planType='" + planType + '\'' +
                ", tenure=" + tenure +
                ", premiumAmount=" + premiumAmount +
                ", insurredAmount=" + insurredAmount +
                '}';
    }
}
