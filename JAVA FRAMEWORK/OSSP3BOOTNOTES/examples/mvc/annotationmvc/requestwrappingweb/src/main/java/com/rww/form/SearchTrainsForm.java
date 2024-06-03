package com.rww.form;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class SearchTrainsForm {
    private String source;
    private String destination;
    private String trainType;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private LocalDate travelDate;
}
