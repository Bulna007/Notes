package com.nbf.beans;

public class Doctor {
	private int doctorNo;
	private String doctorName;
	private String qualification;
	private int experience;

	public Doctor(int doctorNo, String doctorName) {
		this.doctorNo = doctorNo;
		this.doctorName = doctorName;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	@Override
	public String toString() {
		return "Doctor [doctorNo=" + doctorNo + ", doctorName=" + doctorName + ", qualification=" + qualification
				+ ", experience=" + experience + "]";
	}

}
