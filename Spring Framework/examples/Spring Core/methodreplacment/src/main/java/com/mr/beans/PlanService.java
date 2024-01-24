package com.mr.beans;

import java.util.Arrays;
import java.util.List;

public class PlanService {
	public List<String> findPlans(int zipCode, int age, String gender, int copay, boolean outpatientCoverage,
			boolean outofNetworkCoverage) {
		return Arrays.asList(new String[] { "oldplan001", "oldplan002" });
	}
}
