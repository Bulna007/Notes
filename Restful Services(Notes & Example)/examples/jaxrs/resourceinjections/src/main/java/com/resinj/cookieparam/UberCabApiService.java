package com.resinj.cookieparam;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/uber")
public class UberCabApiService {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{source}/{destination}/estimate")
    public String estimateTrip(@PathParam("source") String source, @PathParam("destination") String destination,
                               @QueryParam("cabType") @DefaultValue("mini") String cabType,
                               @CookieParam("activeSession") String activeSession) {
        return "Source : " + source + " destination : " + destination + " cabType : " + cabType
                + " activeSession : " + activeSession;
    }
}
