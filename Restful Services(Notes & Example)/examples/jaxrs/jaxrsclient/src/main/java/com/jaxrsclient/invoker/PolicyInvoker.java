package com.jaxrsclient.invoker;

import com.jaxrsclient.dto.EnrollmentForm;
import com.jaxrsclient.dto.Policy;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.Response;
import org.glassfish.jersey.jackson.JacksonFeature;

public class PolicyInvoker {
    private final String ROOT_RESOURCE_URI = "http://localhost:8080/customcontenthandlers/api/policy";
    private Client client;

    public PolicyInvoker() {
        client = ClientBuilder.newClient();
        client.register(JacksonFeature.class);
    }

    public Policy newPolicy(EnrollmentForm enrollmentForm) {
        Policy policy = null;
        Response response = null;

        response = client.target(ROOT_RESOURCE_URI).path("/new").request().buildPost(Entity.json(enrollmentForm)).invoke();
        if(response.getStatus() == 200) {
            policy = response.readEntity(Policy.class);
        }

        return policy;
    }
}
