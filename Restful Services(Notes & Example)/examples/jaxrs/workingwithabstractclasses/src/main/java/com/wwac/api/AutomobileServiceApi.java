package com.wwac.api;

import com.wwac.dto.Bill;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import java.security.SecureRandom;
import java.time.LocalDate;

abstract public class AutomobileServiceApi {
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String getBill(@QueryParam("jobCardNo") String jobCardNo) {
        // write the logic for computing the bill
        String response = null;
        Bill bill = new Bill(new SecureRandom().nextInt(), jobCardNo, "Blake",
                LocalDate.now(), "TS09BQ9038", 3500);
        response = buildBillResponse(bill);
        return response;
    }

    protected abstract String buildBillResponse(Bill bill);
}
