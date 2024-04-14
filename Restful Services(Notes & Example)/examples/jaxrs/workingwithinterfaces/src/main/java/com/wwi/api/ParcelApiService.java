package com.wwi.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

public interface ParcelApiService {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    String track(@QueryParam(("awbNo")) String awbNo);

}
