package com.dependson.beans;

import java.util.Properties;

import com.dependson.helper.Cache;

public class LoanEnquiryManager {
	private Cache cache;

	public LoanEnquiryManager(Cache cache) {
		this.cache = cache;
	}

	public void enquire(double principleAmount, int tenure, String city) {
		Properties cityRIProps = null;
		float ri = 0.0f;
		double interestAmount = 0.0;
		double repaymentAmount = 0.0;

		cityRIProps = (Properties) cache.get("cityri");
		if (cityRIProps == null) {
			throw new RuntimeException("failed loading the data into Cache");
		} else if (cityRIProps.containsKey(city) == false) {
			throw new RuntimeException("city not found, so loan cannot be issued for the city : " + city);
		}
		ri = Float.parseFloat(cityRIProps.getProperty(city));
		System.out.println("ri : " + ri);
		interestAmount = (principleAmount * (tenure / 12) * ri) / 100;
		repaymentAmount = principleAmount + interestAmount;

		System.out.println("interest amount :" + interestAmount);
		System.out.println("total repayment amount : " + repaymentAmount);

	}
}
