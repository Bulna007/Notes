package com.jh.service;

import com.jh.dto.ProfessionDto;
import com.jh.dto.SpecializationDto;
import com.jh.repository.ProfessionRepository;
import com.jh.repository.SpecializationRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JobService {
    private final ProfessionRepository professionRepository;
    private final SpecializationRepository specializationRepository;

    public List<ProfessionDto> getAllProfessions() {
        return professionRepository.findAll(Sort.by("professionName"))
                .stream()
                .map(ProfessionDto::toProfessionDto).toList();
    }

    public List<SpecializationDto> getSpecializationsByProfession(int professionId) {
        return specializationRepository.getSpecializationsByProfessionId(professionId)
                .stream()
                .map(SpecializationDto::toSpecializationDto).toList();
    }

}
