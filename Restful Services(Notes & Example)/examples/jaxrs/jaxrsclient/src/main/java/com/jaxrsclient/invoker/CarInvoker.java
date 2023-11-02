package com.jaxrsclient.invoker;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;

import java.util.HashMap;
import java.util.Map;

public class CarInvoker {
    private final String ROOT_RESOURCE_URI = "http://localhost:8080/resourceinjections/api/car";
    private Client client;

    public CarInvoker() {
        ClientBuilder builder = ClientBuilder.newBuilder();
        client = builder.build();
    }

    public String searchUsedCars(String model, String manufacturer, String location, int year, String area) {
        String usedCars = null;
        WebTarget webTarget = null;
        Response response = null;
        Invocation.Builder builder = null;
        Invocation invocation = null;

        webTarget = client.target(ROOT_RESOURCE_URI);
        webTarget = webTarget.path("/{model}").matrixParam("year", year).path("/{manufacturer}/{location}")
                .matrixParam("area", area);
        Map<String, Object> templateParameters = new HashMap<>();
        templateParameters.put("model", model);
        templateParameters.put("manufacturer", manufacturer);
        templateParameters.put("location", location);
        webTarget = webTarget.resolveTemplates(templateParameters);

        System.out.println(webTarget.getUri().toString());

        builder = webTarget.request();
        invocation = builder.buildGet();
        response = invocation.invoke();

        if(response.getStatus() == 200) {
            usedCars = response.readEntity(String.class);
        }

        return usedCars;
    }
}





















