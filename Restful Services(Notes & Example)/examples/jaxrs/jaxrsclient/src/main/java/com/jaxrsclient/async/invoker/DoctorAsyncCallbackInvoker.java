package com.jaxrsclient.async.invoker;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.InvocationCallback;
import jakarta.ws.rs.core.Response;

import java.util.Calendar;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class DoctorAsyncCallbackInvoker {
    private final String ROOT_RESOURCE_URI = "http://localhost:8080/serverresponses/api/doctor";

    private Client client;

    public DoctorAsyncCallbackInvoker() {
        client = ClientBuilder.newClient();
    }

    public void showDoctorWithAppointments(int doctorNo) throws ExecutionException, InterruptedException {
        /*Response doctorResponse = client.target(ROOT_RESOURCE_URI).path("/{doctorNo}/info")
                .resolveTemplate("doctorNo", doctorNo).request().get();

        Response appointmentsResponse = client.target(ROOT_RESOURCE_URI).path("/{doctorNo}/appointments").
                resolveTemplate("doctorNo", doctorNo).request().get();
*/
        client.target(ROOT_RESOURCE_URI).path("/{doctorNo}/info")
                .resolveTemplate("doctorNo", doctorNo).request()
                .async().get(new DoctorDetailsCallbackHandler());


        client.target(ROOT_RESOURCE_URI).path("/{doctorNo}/appointments").
                resolveTemplate("doctorNo", doctorNo).request()
                .async().get(new AppointmentsCallbackHandler());
    }

    private final class DoctorDetailsCallbackHandler implements InvocationCallback<Response> {
        @Override
        public void completed(Response doctorResponse) {
            if (doctorResponse.getStatus() == 200) {
                System.out.println(doctorResponse.readEntity(String.class));
            }

        }

        @Override
        public void failed(Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    private final class AppointmentsCallbackHandler implements InvocationCallback<Response> {

        @Override
        public void completed(Response appointmentsResponse) {
            if (appointmentsResponse.getStatus() == 202) {
                System.out.println(appointmentsResponse.readEntity(String.class));
            }
        }

        @Override
        public void failed(Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
