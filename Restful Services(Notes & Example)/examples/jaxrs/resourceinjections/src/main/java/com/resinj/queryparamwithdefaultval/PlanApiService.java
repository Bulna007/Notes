package com.resinj.queryparamwithdefaultval;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/plan")
public class PlanApiService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAvailablePlans(@QueryParam("planType") @DefaultValue("ALL") String planType) {
        String json = null;

        json = "{\"planType\":\"" + planType + "\",\"availablePlans\":[\"plan1\",\"plan2\",\"plan3\"]}";

        return json;
    }
}
