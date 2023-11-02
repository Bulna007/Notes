package com.jaxrsclient.invoker;

import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.Response;

public class NetbankingInvoker {
    private final String ROOT_RESOURCE_URI = "http://localhost:8080/resourceinjections/api/netbanking";

    private Client client;

    public NetbankingInvoker() {
        ClientBuilder clientBuilder = ClientBuilder.newBuilder();
        clientBuilder.property("connection.Timeout", 1000);
        client = clientBuilder.build();
    }

    public String withdrawl(String accountNo, double amount, String platformType) {
        Invocation.Builder builder = null;
        Invocation invocation = null;
        WebTarget webTarget = null;
        Response response = null;
        String receipt = null;

        webTarget = client.target(ROOT_RESOURCE_URI).path("/{accountNo}/{amount}/withdraw");
        webTarget = webTarget.resolveTemplate("accountNo", accountNo).resolveTemplate("amount", amount);

        builder = webTarget.request();
        builder = builder.header("platformType", platformType);

        invocation= builder.buildPut(Entity.text(""));
        response = invocation.invoke();

        if(response.getStatus() == 200) {
            receipt = response.readEntity(String.class);
        }

        return receipt;
    }

}








