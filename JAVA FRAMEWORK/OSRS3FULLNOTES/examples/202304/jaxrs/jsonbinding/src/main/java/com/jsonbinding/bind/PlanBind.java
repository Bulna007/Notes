package com.jsonbinding.bind;

import com.jsonbinding.bean.Plan;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;

public class PlanBind {
    public static void main(String[] args) {
        Jsonb jsonb = JsonbBuilder.create();
//        Plan plan = jsonb.fromJson(PlanBind.class.getClassLoader().getResourceAsStream("plan.json"), Plan.class);
//        System.out.println(plan);

        Plan plan = new Plan();
        plan.setPlanNo(9);
        plan.setPlanName("Arogya Bheema");
        plan.setTenure(93);
        plan.setPremiumAmount(3000);
        plan.setInsurredAmount(300000);
        plan.setPlanType("Medical Plan");
        jsonb.toJson(plan, System.out);
    }
}
