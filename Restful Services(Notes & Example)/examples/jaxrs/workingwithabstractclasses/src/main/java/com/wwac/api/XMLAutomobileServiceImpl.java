package com.wwac.api;

import com.wwac.dto.Bill;
import jakarta.ws.rs.Path;

@Path("/xml/automobiles")
public class XMLAutomobileServiceImpl extends AutomobileServiceApi {
    @Override
    protected String buildBillResponse(Bill bill) {
        StringBuilder builder = new StringBuilder();

        builder.append("<bill><bill-no>").append(bill.getBillNo()).append("</bill-no><jobcard-no>").append(bill.getJobCardNo())
                .append("</jobcard-no><bill-generated-dt>").append(bill.getBillGeneratedDate().toString())
                .append("</bill-generated-dt><supervisor-name>")
                .append(bill.getSupervisorName()).append("</supervisor-name><registration-no>").append(bill.getRegistrationNo())
                .append("</registration-no><amount>")
                .append(bill.getAmount()).append("</amount></bill>");
        return builder.toString();
    }
}
