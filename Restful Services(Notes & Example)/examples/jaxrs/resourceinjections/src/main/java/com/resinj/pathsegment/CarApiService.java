package com.resinj.pathsegment;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.PathSegment;

@Path("/car")
public class CarApiService {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{model}/{manufacturer}/{location}")
    public String searchUsedCars(@PathParam("model") PathSegment model, @PathParam("manufacturer") PathSegment manufacturer,
                                 @PathParam("location") PathSegment location) {
        StringBuilder builder = new StringBuilder();
        builder.append("model : ").append(model.getPath()).append(" matrix params : ").
                append(extractMatrixParams(model.getMatrixParameters())).append("/manufacturer : ").append(manufacturer.getPath())
                .append(" matrix params : ").append(extractMatrixParams(manufacturer.getMatrixParameters()))
                .append("/location :").append(location.getPath()).append(" matrix params : ").append(extractMatrixParams(location.getMatrixParameters()));

        return builder.toString();
    }

    private String extractMatrixParams(MultivaluedMap<String, String> multivaluedMap) {
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
