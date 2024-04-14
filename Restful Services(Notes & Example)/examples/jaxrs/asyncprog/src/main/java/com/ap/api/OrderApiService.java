package com.ap.api;

import com.ap.dto.OrderDto;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.container.AsyncResponse;
import jakarta.ws.rs.container.Suspended;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("/order")
public class OrderApiService {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/new")
    public void processOrder(final OrderDto orderDto, final @Suspended AsyncResponse asyncResponse) {
        // perform processing in a new thread of execution without block jaxrs runtime
        new Thread(() -> {

            try {
                System.out.println("processing order");
                Thread.sleep(1000L);
                Response response = Response.ok(UUID.randomUUID().toString()).build();
                asyncResponse.resume(response);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
