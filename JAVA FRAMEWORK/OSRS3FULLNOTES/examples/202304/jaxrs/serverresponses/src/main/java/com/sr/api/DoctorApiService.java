package com.sr.api;

import com.sr.dto.Appointment;
import com.sr.dto.DoctorDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.NewCookie;
import jakarta.ws.rs.core.Response;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Path("/doctor")
public class DoctorApiService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{doctorNo}/info")
    public DoctorDto getDoctor(@PathParam("doctorNo") int doctorNo) throws InterruptedException {
        DoctorDto doctorDto = null;

        doctorDto = DoctorDto.of().doctorNo(doctorNo).doctorName("Joseph").age(35)
                .gender("Male").mobileNo("938374844").emailAddress("jospeh@gmail.com")
                .experience(6).qualification("MBBS").specialization("Cardiac").build();
        Thread.sleep(100L);
        System.out.println("returning doctor details");
        return doctorDto;
    }

    @GET
    @Path("/{doctorNo}/appointments")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAppointmentsForDoctor(@PathParam("doctorNo") int doctorNo) throws InterruptedException {
        List<Appointment> appointments = null;
        Response.ResponseBuilder builder = null;
        Response response = null;

        appointments = new ArrayList<>();
        appointments.add(Appointment.builder().appointmentNo(33).patientName("Paul")
                .appointmentTime(LocalDateTime.of(2023, 8, 01, 10, 20)).of());
        appointments.add(Appointment.builder().appointmentNo(34).patientName("Peter")
                .appointmentTime(LocalDateTime.of(2023, 8, 01, 10, 30)).of());


        builder = Response.status(Response.Status.ACCEPTED);
        builder.entity(Entity.json(appointments));
        response = builder.build();
        //Thread.sleep(100L);
        System.out.println("returning appointment for doctor details");

        return response;
    }

    @GET
    @Path("/{appointmentNo}/appointment")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAppointment(@PathParam("appointmentNo") int appointmentNo) {
        Response.ResponseBuilder builder = null;
        Appointment appointment = null;
        Response response = null;

        appointment = Appointment.builder().appointmentNo(93).patientName("Andrew").appointmentTime(LocalDateTime.now()).of();
        builder = Response.accepted();
        builder = builder.header("clerk-no", "9383");
        builder = builder.cookie(new NewCookie("promotionCode", "93874"));
        builder = builder.entity(Entity.json(appointment));

        response = builder.build();

        return response;
    }


}





















