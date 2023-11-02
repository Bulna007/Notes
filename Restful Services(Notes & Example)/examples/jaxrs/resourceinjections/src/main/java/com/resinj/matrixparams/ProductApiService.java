package com.resinj.matrixparams;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/product")
public class ProductApiService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{category}/{productName}")
    public String searchProducts(@PathParam("category") String category, @PathParam("productName") String productName,
                                 @MatrixParam("connectorType") String connectorType, @MatrixParam("volts") String volts,
                                 @MatrixParam("type") String cameraType, @MatrixParam("lens") String lensType) {
        StringBuilder builder = new StringBuilder();
        builder.append("{'category':'").append(category).append("', 'productName':'").append(productName)
                .append("','connectorType':'").append(connectorType).append("','volts':'").append(volts).append("','cameraType':'")
                .append(cameraType).append("','lens':'").append(lensType).append("'}");

        return builder.toString();
    }
}
