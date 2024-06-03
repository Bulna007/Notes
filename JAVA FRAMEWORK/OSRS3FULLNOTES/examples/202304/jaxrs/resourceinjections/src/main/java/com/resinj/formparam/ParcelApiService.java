package com.resinj.formparam;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/parcel")
public class ParcelApiService {

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/newConsignment")
    public String newConsignment(@FormParam("source") String source, @FormParam("destination") String destination,
                                 @FormParam("description") String description, @FormParam("weight") int weight) {
        return "source : " + source + " destination : " + destination + " description : " + description + " weight : " + weight;
    }
}
