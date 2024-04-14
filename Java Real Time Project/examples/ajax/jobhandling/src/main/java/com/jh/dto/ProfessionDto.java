package com.jh.dto;

import com.jh.entities.Profession;
import lombok.Data;

@Data
public class ProfessionDto {
    private int professionId;
    private String professionName;

    public static ProfessionDto toProfessionDto(Profession profession) {
        ProfessionDto dto = new ProfessionDto();

        dto.setProfessionId(profession.getProfessionId());
        dto.setProfessionName(profession.getProfessionName());

        return dto;
    }
}
