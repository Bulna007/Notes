package com.jaxrsclient.invoker;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;

public class UberInvoker {
    private final String ROOT_RESOURCE_URI = "http://localhost:8080/resourceinjections/api/uber";
    private Client client;

    public UberInvoker() {
        client = ClientBuilder.newClient();
    }

    public String estimate(String source, String destination, String cabType, String activeSession) {
        String estimate = null;
        Response response = null;

        response = client.target(ROOT_RESOURCE_URI).path("/{source}/{destination}/estimate")
                .resolveTemplate("source", source)
                .resolveTemplate("destination", destination)
                .queryParam("cabType", cabType).request()
                .cookie("activeSession", activeSession).buildGet().invoke();
        if(response.getStatus() == 200) {
            estimate = response.readEntity(String.class);
        }

        return estimate;
    }
}
