package com.srl.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

public class PhilipsStereoCustomercareApiService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/warranty")
    public String getWarranty(@QueryParam("serialNo") String serialNo) {
        return "{'serialNo': '" + serialNo + "', 'warranty':'in-warranty'}";
    }
}
