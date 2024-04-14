package com.rbs.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/policy")
public class PolicyApiService {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getPolicyHolderName(@QueryParam("policyNo") String policyNo) {
		return "Policy Holder Name: Steve for the policy : " + policyNo;
	}
}
