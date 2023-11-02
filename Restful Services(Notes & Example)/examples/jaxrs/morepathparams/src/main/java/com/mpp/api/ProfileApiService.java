package com.mpp.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/profile")
public class ProfileApiService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{mobileNumber: \\d{10}}")
    public String getProfile(@PathParam("mobileNumber") String mobileNumber) {
        return "{'mobileNumber':'" + mobileNumber + "', 'profileName': 'bob', 'location': 'NY, USA'}";
    }
}
