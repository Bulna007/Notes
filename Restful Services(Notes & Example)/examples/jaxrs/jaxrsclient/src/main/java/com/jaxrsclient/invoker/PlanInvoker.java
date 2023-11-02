package com.jaxrsclient.invoker;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;

public class PlanInvoker {
    public String getAvailablePlans(String planType) {
        ClientBuilder clientBuilder = null;
        Client client = null;
        WebTarget webTarget = null;
        Invocation.Builder builder = null;
        Invocation invocation = null;
        Response response = null;
        String availablePlans = null;

        clientBuilder = ClientBuilder.newBuilder();
        client = clientBuilder.build();
        webTarget = client.target("http://localhost:8080/resourceinjections/api/plan");
        webTarget = webTarget.queryParam("planType", planType);
        builder = webTarget.request();
        invocation = builder.buildGet();

        response = invocation.invoke();

        if (response.getStatus() == 200) {
            availablePlans = response.readEntity(String.class);
        }
        return availablePlans;
    }
}
