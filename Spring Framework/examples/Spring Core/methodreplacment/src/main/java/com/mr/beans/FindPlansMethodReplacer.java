package com.mr.beans;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.beans.factory.support.MethodReplacer;

public class FindPlansMethodReplacer implements MethodReplacer {

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		// Recommended check
		if (method.getName().equals("findPlans")) {
			int zipCode = (Integer) args[0];
			int age = (Integer) args[1];
			String gender = (String) args[2];
			int copay = (Integer) args[3];
			boolean outpatientCoverage = (Boolean) args[4];
			boolean outOfNetworkCoverage = (Boolean) args[5];

			System.out.println("executing reimplement(zipCode :" + zipCode + ", age : " + age + ", gender : " + gender
					+ ", copay : " + copay + ", outPatientCoverage: " + outpatientCoverage + ", outOfNetworkCoverage: "
					+ outOfNetworkCoverage + ")");
			return Arrays.asList(new String[] { "plan001", "plan002", "plan003" });

		} else {
			throw new RuntimeException("doesnt support replacing method : " + method.getName());
		}
	}

}
