package com.hbs.api;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;

import java.security.SecureRandom;

@Path("/account")
public class AccountApiService {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{accountNo}/balance")
    //@RolesAllowed("customer")
    public double getBalance(@PathParam("accountNo") String accountNo, @Context SecurityContext securityContext) {

        System.out.println(securityContext.getUserPrincipal().getName());

        if (securityContext.isUserInRole("customer")) {
            return new SecureRandom().nextDouble(999999);
        } else {
            throw new ForbiddenException("Not allowed");
        }
    }
}
