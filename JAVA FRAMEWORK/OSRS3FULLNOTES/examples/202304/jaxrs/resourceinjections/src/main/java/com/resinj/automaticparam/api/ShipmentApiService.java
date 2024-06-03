package com.resinj.automaticparam.api;

import com.resinj.automaticparam.bean.AwbNo;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/shipment")
public class ShipmentApiService {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{awbNo}/track")
    public String track(@PathParam("awbNo") AwbNo awbNo) {
        return "awbNo : " + awbNo + " status : in-transit";
    }
}
