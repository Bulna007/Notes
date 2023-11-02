package com.cch.api;

import com.cch.dto.EnrollmentForm;
import com.cch.dto.Policy;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.security.SecureRandom;
import java.util.UUID;

@Path("/policy")
public class PolicyApiService {

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("/new")
    public Policy newPolicy(EnrollmentForm form) {
        Policy policy = new Policy();

        System.out.println("recieved enrollment request with details : " + form);
        policy.setPolicyNo(UUID.randomUUID().toString());
        policy.setPolicyHolderName(form.getFullname());
        policy.setTenure(form.getTenure());
//        policy.setEffectiveDate(LocalDate.now());
//        policy.setMaturityDate(LocalDate.now().plusMonths(form.getTenure()));
        policy.setInsurredAmount(form.getInsurredAmount());
        policy.setStatus("In-Force");
        policy.setPremiumAmount(new SecureRandom().nextDouble(9999));
        policy.setPlanName(form.getPlanName());

        return policy;
    }
}
