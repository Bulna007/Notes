package com.rww.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(builderMethodName = "of")
public class TrainDto {
    private int trainNo;
    private String source;
    private String destination;
    private int duration;
    private String trainType;
    private String departureTime;
    private String arrivalTime;
}
