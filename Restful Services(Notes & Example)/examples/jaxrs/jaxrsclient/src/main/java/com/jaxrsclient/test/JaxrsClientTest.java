package com.jaxrsclient.test;

import com.jaxrsclient.dto.EnrollmentForm;
import com.jaxrsclient.dto.Policy;
import com.jaxrsclient.invoker.*;

public class JaxrsClientTest {
    public static void main(String[] args) {
//        PlanInvoker planInvoker = new PlanInvoker();
//        String availablePlans = planInvoker.getAvailablePlans("Retirement");
//        System.out.println(availablePlans);

        /*CarInvoker carInvoker = new CarInvoker();
        String usedCars = carInvoker.searchUsedCars("Swift", "Maruthi", "Hyderabad", 2022, "Madhapur");
        System.out.println(usedCars);*/

//        NetbankingInvoker netbankingInvoker = new NetbankingInvoker();
//        String receipt = netbankingInvoker.withdrawl("ac003", 3938, "mobile");
//        System.out.println(receipt);
//        UberInvoker uberInvoker = new UberInvoker();
//        System.out.println(uberInvoker.estimate("Madhpur", "Gachibowli", "mini", "ac938944"));

        EnrollmentForm enrollmentForm = new EnrollmentForm();
        enrollmentForm.setFullname("Alex");
        enrollmentForm.setGender("Male");
        enrollmentForm.setTenure(3);
        enrollmentForm.setInsurredAmount(93838);
        enrollmentForm.setPlanName("Jn2");
        enrollmentForm.setMobileNo("939379478");
        enrollmentForm.setEmailAddress("alex@gmail.com");
        enrollmentForm.setPlanNo("p9383");

        PolicyInvoker policyInvoker = new PolicyInvoker();
        Policy policy = policyInvoker.newPolicy(enrollmentForm);
        System.out.println(policy);
    }
}
