package com.jpaorm.test;

import com.jpaorm.dao.InsurancePlanDao;
import com.jpaorm.entities.InsurancePlan;
import com.jpaorm.helper.EMFRegistry;

public class JPAORMTest {
	public static void main(String[] args) {
		try {
			InsurancePlanDao dao = new InsurancePlanDao();
			InsurancePlan insurancePlan = dao.getInsurancePlan(1001);
			System.out.println(insurancePlan);
//			InsurancePlan insurancePlan = new InsurancePlan();
//			insurancePlan.setPlanNo(1002);
//			insurancePlan.setPlanName("Retirement Plan");
//			insurancePlan.setPlanType("Retirement Benefits");
//			insurancePlan.setMinAge(5);
//			insurancePlan.setMinTenure(36);
//			insurancePlan.setMinInsurredAmount(50000);
//			insurancePlan.setMaturityBonusPercentage(10);
//
//			dao.saveInsurancePlan(insurancePlan);

		} finally {
			EMFRegistry.closeEmf();
		}
	}
}
