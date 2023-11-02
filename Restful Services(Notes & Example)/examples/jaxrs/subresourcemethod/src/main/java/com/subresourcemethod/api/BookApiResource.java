package com.subresourcemethod.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import java.security.SecureRandom;

@Path("/book")
public class BookApiResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/price")
    public double getBookPrice(@QueryParam("isbn") String isbn) {
        System.out.println("getBookPrice(), isbn : " + isbn);
        SecureRandom random = new SecureRandom();
        return random.nextDouble();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/author")
    public String getAuthor(@QueryParam("isbn") String isbn) {
        System.out.println("getAuthor(), isbn: " + isbn);
        return "Micheal";
    }
}
