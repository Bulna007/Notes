package com.resinj.httpheaders;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;

@Path("/workschedule")
public class WorkScheduleManagerApiService {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{week}")
    public String getWorkSchedulesOfaWeek(@Context HttpHeaders httpHeaders, @PathParam("week") int week) {
        MultivaluedMap<String, String> headerParams = httpHeaders.getRequestHeaders();
        StringBuilder builder = new StringBuilder();
        builder.append("headers : ").append(extractMultiValuedMap(headerParams)).append(" path parameter week: " + week);
        return builder.toString();
    }

    private String extractMultiValuedMap(MultivaluedMap<String, String> multivaluedMap) {
        StringBuilder builder = new StringBuilder();

        multivaluedMap.forEach((key, list) -> {
            builder.append(key).append("=");
            boolean f = true;
            for (String val : list) {
                if (f) {
                    builder.append(val);
                    f = false;
                    continue;
                }
                builder.append(",").append(val);
            }
            builder.append(";");
        });

        return builder.toString();
    }
}
