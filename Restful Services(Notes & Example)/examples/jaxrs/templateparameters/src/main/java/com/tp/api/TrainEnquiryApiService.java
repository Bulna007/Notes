package com.tp.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/trainEnquiry")
public class TrainEnquiryApiService {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{trainNo}/status")
    public String getRunningStatus(@PathParam("trainNo") String trainNo) {
        return "TrainNo: " + trainNo + " Live status : Ghaziabad";
    }
}
