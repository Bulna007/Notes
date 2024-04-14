package com.awareinterface.beans;

public class Rocket {
	private int rocketNo;
	private String rocketName;
	private int weight;

	public void propel() {
		System.out.println("rocket no : " + rocketNo + " rocket name: " + rocketName + " with weight : " + weight
				+ " has been propelled...");
	}

	public void setRocketNo(int rocketNo) {
		this.rocketNo = rocketNo;
	}

	public void setRocketName(String rocketName) {
		this.rocketName = rocketName;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
