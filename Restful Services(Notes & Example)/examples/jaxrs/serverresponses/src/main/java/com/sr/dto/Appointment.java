package com.sr.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder(buildMethodName = "of")
public class Appointment {
    private int appointmentNo;
    private String patientName;
    private LocalDateTime appointmentTime;

}
