package com.msf.entities;

import java.io.Serializable;
import java.util.Objects;

public class LoanEnquire implements Serializable {
	private static final long serialVersionUID = 7118545203042660084L;
	private int loanEnquireNo;
	private String applicantName;
	private String mobileNo;
	private String emailAddress;
	private String loanType;
	private double principleAmount;
	private int tenure;

	public int getLoanEnquireNo() {
		return loanEnquireNo;
	}

	public void setLoanEnquireNo(int loanEnquireNo) {
		this.loanEnquireNo = loanEnquireNo;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public double getPrincipleAmount() {
		return principleAmount;
	}

	public void setPrincipleAmount(double principleAmount) {
		this.principleAmount = principleAmount;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	@Override
	public int hashCode() {
		return Objects.hash(applicantName, emailAddress, loanEnquireNo, loanType, mobileNo, principleAmount, tenure);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoanEnquire other = (LoanEnquire) obj;
		return Objects.equals(applicantName, other.applicantName) && Objects.equals(emailAddress, other.emailAddress)
				&& loanEnquireNo == other.loanEnquireNo && Objects.equals(loanType, other.loanType)
				&& Objects.equals(mobileNo, other.mobileNo)
				&& Double.doubleToLongBits(principleAmount) == Double.doubleToLongBits(other.principleAmount)
				&& tenure == other.tenure;
	}

	@Override
	public String toString() {
		return "LoanEquire [loanEnquireNo=" + loanEnquireNo + ", applicantName=" + applicantName + ", mobileNo="
				+ mobileNo + ", emailAddress=" + emailAddress + ", loanType=" + loanType + ", principleAmount="
				+ principleAmount + ", tenure=" + tenure + "]";
	}

}
