package com.planmgmt.test;

import com.planmgmt.config.RootConfig;
import com.planmgmt.dto.PlanDto;
import com.planmgmt.service.PlanService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PlanMgmtTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(RootConfig.class);
        PlanService planService = applicationContext.getBean("planService", PlanService.class);
//        PlanDto dto = PlanDto.of().planName("Risk Management Plan").planType("Risk Coverage").description("Plan 1").eligibilityCriteria("N/A").build();
//
//
//        int planNo = planService.newPlan(dto);
//
//        PlanDto dto1 = planService.findPlan(planNo);
//        System.out.println(dto1);

        //planService.findAll("planName").forEach(System.out::println);
        //planService.findAll(0, 3).forEach(System.out::println);
        //planService.findPlansByPlanType("Risk%").forEach(System.out::println);
        //long c = planService.findNoOfPlansByPlanType("Risk Coverage");
        //System.out.println("count : " +c);
        int r = planService.updatePlanEligibilityByPlanType("Not served", "Risk Management");
        System.out.println("r : " + r);
    }
}
