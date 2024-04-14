package com.wwac.api;

import com.wwac.dto.Bill;
import jakarta.ws.rs.Path;

@Path("/json/automobiles")
public class JSONAutomobileServiceApiImpl extends AutomobileServiceApi {
    @Override
    protected String buildBillResponse(Bill bill) {
        StringBuilder builder = new StringBuilder();
        builder.append("{'billNo' :").append(bill.getBillNo()).append(",'jobCardNo':'").
                append(bill.getJobCardNo()).append("','billGeneratedDate':'").append(bill.getBillGeneratedDate().toString())
                .append("','superVisorName':'").append(bill.getSupervisorName()).append("','registrationNo':")
                .append(bill.getRegistrationNo()).append("', 'amount':").append(bill.getAmount()).append("}");

        return builder.toString();
    }
}
