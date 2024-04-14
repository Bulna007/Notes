package com.jh.dto;

import com.jh.entities.Specialization;
import lombok.Data;

@Data
public class SpecializationDto {
    private int specializationId;
    private String specializationName;

    public static SpecializationDto toSpecializationDto(Specialization specialization) {
        SpecializationDto dto = new SpecializationDto();
        dto.setSpecializationId(specialization.getSpecializationId());
        dto.setSpecializationName(specialization.getSpecializationName());
        return dto;
    }
}
