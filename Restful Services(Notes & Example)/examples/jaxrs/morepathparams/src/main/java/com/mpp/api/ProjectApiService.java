package com.mpp.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/project/{projectNo}")
public class ProjectApiService {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/progress/{projectNo}")
    public String getProgress(@PathParam("projectNo") String projectNo) {
        return "Project No : " + projectNo + " progress: on-time";
    }
}
