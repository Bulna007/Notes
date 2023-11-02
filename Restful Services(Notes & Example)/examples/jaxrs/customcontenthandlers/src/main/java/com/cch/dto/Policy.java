package com.cch.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name="Policy")
@XmlRootElement(name="policy")
@XmlAccessorType(XmlAccessType.FIELD)
public class Policy {
    private String policyNo;
    private String policyHolderName;
    private String planName;
    private int tenure;
    private double insurredAmount;
    private double premiumAmount;
    //@JsonbDateFormat("dd/MM/yyyy")
//    @JsonFormat(pattern = "dd/MM/yyyy")
//    private LocalDate effectiveDate;
    //@JsonbDateFormat("dd/MM/yyyy")
//    @JsonFormat(pattern = "dd/MM/yyyy")
//    private LocalDate maturityDate;
    private String status;

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getPolicyHolderName() {
        return policyHolderName;
    }

    public void setPolicyHolderName(String policyHolderName) {
        this.policyHolderName = policyHolderName;
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

    public double getInsurredAmount() {
        return insurredAmount;
    }

    public void setInsurredAmount(double insurredAmount) {
        this.insurredAmount = insurredAmount;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(double premiumAmount) {
        this.premiumAmount = premiumAmount;
    }

//    public LocalDate getEffectiveDate() {
//        return effectiveDate;
//    }
//
//    public void setEffectiveDate(LocalDate effectiveDate) {
//        this.effectiveDate = effectiveDate;
//    }
//
//    public LocalDate getMaturityDate() {
//        return maturityDate;
//    }
//
//    public void setMaturityDate(LocalDate maturityDate) {
//        this.maturityDate = maturityDate;
//    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
