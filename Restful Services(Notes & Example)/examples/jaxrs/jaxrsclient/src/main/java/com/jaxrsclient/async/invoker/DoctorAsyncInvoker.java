package com.jaxrsclient.async.invoker;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.Response;

import java.util.Calendar;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class DoctorAsyncInvoker {
    private final String ROOT_RESOURCE_URI = "http://localhost:8080/serverresponses/api/doctor";

    private Client client;

    public DoctorAsyncInvoker() {
        client = ClientBuilder.newClient();
    }

    public void showDoctorWithAppointments(int doctorNo) throws ExecutionException, InterruptedException {
        long startTime = Calendar.getInstance().getTimeInMillis();
        /*Response doctorResponse = client.target(ROOT_RESOURCE_URI).path("/{doctorNo}/info")
                .resolveTemplate("doctorNo", doctorNo).request().get();

        Response appointmentsResponse = client.target(ROOT_RESOURCE_URI).path("/{doctorNo}/appointments").
                resolveTemplate("doctorNo", doctorNo).request().get();
*/
        Future<Response> doctorFutureResponse = client.target(ROOT_RESOURCE_URI).path("/{doctorNo}/info")
                .resolveTemplate("doctorNo", doctorNo).request().async().get();


        Future<Response> appointmentsFutureResponse = client.target(ROOT_RESOURCE_URI).path("/{doctorNo}/appointments").
                resolveTemplate("doctorNo", doctorNo).request().async().get();

        Response doctorResponse = doctorFutureResponse.get();
        Response appointmentsResponse = appointmentsFutureResponse.get();

        if (doctorResponse.getStatus() == 200) {
            System.out.println(doctorResponse.readEntity(String.class));
        }
        if (appointmentsResponse.getStatus() == 202) {
            System.out.println(appointmentsResponse.readEntity(String.class));
        }
        long endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println("total time : " + (endTime - startTime));
    }
}














