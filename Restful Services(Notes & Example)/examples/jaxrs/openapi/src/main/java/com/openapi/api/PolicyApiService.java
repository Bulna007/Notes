package com.openapi.api;

import com.openapi.dto.EnrollmentForm;
import com.openapi.dto.PolicyDetails;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.time.LocalDate;
import java.util.UUID;

@Path("/policy")
@OpenAPIDefinition(info = @Info(title = "PolicyApiService", description = "Policy service, provides enrollment and policy details..",
        contact = @Contact(name = "sriman", email = "tech.sriman@gmail.com"), version = "1.0"),
        servers = {@Server(description = "dev", url = "http://localhost:8080/openapi")})
public class PolicyApiService {

    @POST
    @Path("/new")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(method = "newPolicy", description = "enroll policy",
            requestBody = @RequestBody(description = "enrollmentForm", required = true, useParameterTypeSchema = true)
            , responses = {@ApiResponse(description = "policy details", useReturnTypeSchema = true, responseCode = "200")})
    public PolicyDetails newPolicy(EnrollmentForm form) {
        String policyNo = UUID.randomUUID().toString().substring(0, 8);
        return PolicyDetails.of().policyNo(policyNo).policyHolderName(form.getCustomerName())
                .effectiveDate(LocalDate.now()).maturityDate(LocalDate.now().plusMonths(form.getTenure()))
                .insurredAmount(form.getInsurredAmount())
                .planName("Jeevan Suraksha").premiumAmount(form.getInsurredAmount() / form.getTenure()).build();
    }
}
