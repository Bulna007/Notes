package com.eh.api;

import com.eh.dto.Error;
import com.eh.dto.Receipt;
import com.eh.dto.RechargeInfo;
import com.eh.exception.SubscriptionNotActiveException;
import com.eh.service.RechargeService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/recharge")
public class MobileRechargeApiService {
    @Path("/noexcepmgmt")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Receipt rechargeWithNoExceptionManagement(RechargeInfo rechargeInfo) {
        RechargeService rechargeService = null;
        String receiptNo = null;
        Receipt receipt = null;

        rechargeService = new RechargeService();
        receiptNo = rechargeService.recharge(rechargeInfo.getMobileNo(), rechargeInfo.getPlan(), rechargeInfo.getAmount());
        receipt = Receipt.of().receiptNo(receiptNo).mobileNo(rechargeInfo.getMobileNo())
                .amount(rechargeInfo.getAmount()).status("Success").build();
        return receipt;
    }

    @Path("/excepResponse")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response rechargeWithExceptionAsResponse(RechargeInfo rechargeInfo) {
        RechargeService rechargeService = null;
        String receiptNo = null;
        Receipt receipt = null;

        rechargeService = new RechargeService();
        try {
            receiptNo = rechargeService.recharge(rechargeInfo.getMobileNo(), rechargeInfo.getPlan(), rechargeInfo.getAmount());
            receipt = Receipt.of().receiptNo(receiptNo).mobileNo(rechargeInfo.getMobileNo())
                    .amount(rechargeInfo.getAmount()).status("Success").build();
        } catch (SubscriptionNotActiveException e) {
            Response response = Response.status(Response.Status.BAD_REQUEST)
                    .entity(Entity.json(Error.of().errorCode("A001").errorMessage("Subscription Not Active").build()))
                    .build();
            return response;
        }
        return Response.ok(Entity.json(receipt)).build();
    }

    @Path("/excep")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response rechargeWithException(RechargeInfo rechargeInfo) {
        RechargeService rechargeService = null;
        String receiptNo = null;
        Receipt receipt = null;

        rechargeService = new RechargeService();
        try {
            receiptNo = rechargeService.recharge(rechargeInfo.getMobileNo(), rechargeInfo.getPlan(), rechargeInfo.getAmount());
            receipt = Receipt.of().receiptNo(receiptNo).mobileNo(rechargeInfo.getMobileNo())
                    .amount(rechargeInfo.getAmount()).status("Success").build();
        } catch (SubscriptionNotActiveException e) {
            Response response = Response.status(Response.Status.BAD_REQUEST)
                    .entity(Entity.json(Error.of().errorCode("A001").errorMessage("Subscription Not Active").build()))
                    .build();
            throw new WebApplicationException(response);
        }
        return Response.ok(Entity.json(receipt)).build();
    }

}
