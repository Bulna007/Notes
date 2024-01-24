package com.txmgmt.bo;

public class SubscriberBo {
	private String subscriptionType;
	private String planName;
	private String circle;
	private int validityDays;
	private double billAmount;
	private int customerNo;

	public String getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(String subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getCircle() {
		return circle;
	}

	public void setCircle(String circle) {
		this.circle = circle;
	}

	public int getValidityDays() {
		return validityDays;
	}

	public void setValidityDays(int validityDays) {
		this.validityDays = validityDays;
	}

	public double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}

	public int getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}

}
