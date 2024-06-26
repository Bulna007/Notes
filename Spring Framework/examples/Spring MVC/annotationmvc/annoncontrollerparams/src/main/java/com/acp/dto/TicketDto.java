package com.acp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Builder(builderMethodName = "of")
@Getter
public class TicketDto {
    private String pnrNo;
    private String passengerName;
    private String source;
    private String destination;
    private LocalDate travelDate;
    private String coach;
    private int berth;
    private String status;
}
