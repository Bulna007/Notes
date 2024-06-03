package com.moreorm.entities;

import java.io.Serializable;
import java.util.Objects;

public class Branch implements Serializable {
	private static final long serialVersionUID = -1815583635846834936L;
	private int branchNo;
	private String branchName;
	private String ifscCode;
	private String location;
	private int zipcode;
	private String contactNo;

	public int getBranchNo() {
		return branchNo;
	}

	public void setBranchNo(int branchNo) {
		this.branchNo = branchNo;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(branchName, branchNo, contactNo, ifscCode, location, zipcode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Branch other = (Branch) obj;
		return Objects.equals(branchName, other.branchName) && branchNo == other.branchNo
				&& Objects.equals(contactNo, other.contactNo) && Objects.equals(ifscCode, other.ifscCode)
				&& Objects.equals(location, other.location) && zipcode == other.zipcode;
	}

	@Override
	public String toString() {
		return "Branch [branchNo=" + branchNo + ", branchName=" + branchName + ", ifscCode=" + ifscCode + ", location="
				+ location + ", zipcode=" + zipcode + ", contactNo=" + contactNo + "]";
	}

}
