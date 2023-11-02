package com.resinj.headerparam;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/netbanking")
public class NetbankingApiService {

    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{accountNo}/{amount}/withdraw")
    public String withdrawl(@PathParam("accountNo") String accountNo,
                            @PathParam("amount") double amount, @HeaderParam("platformType") String platformType) {
        return "accountNo : " + accountNo + " amount : " + amount + " platformType: " + platformType;
    }
}
