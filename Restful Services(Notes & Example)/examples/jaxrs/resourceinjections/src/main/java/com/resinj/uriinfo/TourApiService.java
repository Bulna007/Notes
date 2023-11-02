package com.resinj.uriinfo;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.UriInfo;

@Path("/tour/{location}")
public class TourApiService {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{tourType}/{location}/search")
    public String searchTourPackages(@Context UriInfo uriInfo) {
        StringBuilder builder = new StringBuilder();

        uriInfo.getPathSegments().forEach(pathSegment -> {
            builder.append(pathSegment.getPath()).append(" matrixParams : ")
                    .append(extractMultiValuedMap(pathSegment.getMatrixParameters())).append("/");
        });
        builder.append("?").append(extractMultiValuedMap(uriInfo.getQueryParameters()));

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
