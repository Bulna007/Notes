package com.javaconfigpi.annotation;

// no source code
public class Passport {
	private int passportNo;
	private String passportHolderName;
	private int age;
	private String gender;

	public void setPassportNo(int passportNo) {
		this.passportNo = passportNo;
	}

	public void setPassportHolderName(String passportHolderName) {
		this.passportHolderName = passportHolderName;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Passport [passportNo=" + passportNo + ", passportHolderName=" + passportHolderName + ", age=" + age
				+ ", gender=" + gender + "]";
	}

}
