package com.srl.api;

import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import java.time.LocalDate;

public class PhilipsHomeAppliancesCustomercareApiService {

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/extendWarranty")
    public String extendedWarranty(@QueryParam("serialNo") String serialNo) {
        return "{'serialNo':'" + serialNo + "', 'extendedDate':'" + LocalDate.now().plusMonths(12) + "'}";
    }
}
