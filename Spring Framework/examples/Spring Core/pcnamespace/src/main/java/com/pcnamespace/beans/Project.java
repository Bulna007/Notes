package com.pcnamespace.beans;

public class Project {
	private int projectNo;
	private String title;
	private String clientName;
	private int teamSize;
	private Contract contract;

	public Project(int projectNo, String title, Contract contract) {
		this.projectNo = projectNo;
		this.title = title;
		this.contract = contract;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

	@Override
	public String toString() {
		return "Project [projectNo=" + projectNo + ", title=" + title + ", clientName=" + clientName + ", teamSize="
				+ teamSize + ", contract=" + contract + "]";
	}

}
