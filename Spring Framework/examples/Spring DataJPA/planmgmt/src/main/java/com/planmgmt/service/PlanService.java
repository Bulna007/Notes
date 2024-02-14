package com.planmgmt.service;

import com.planmgmt.dto.PlanDto;
import com.planmgmt.entities.Plan;
import com.planmgmt.repositories.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanService {
    @Autowired
    private PlanRepository planRepository;

    @Transactional(readOnly = false)
    public int newPlan(PlanDto planDto) {
        Plan plan = new Plan();
        plan.setPlanName(planDto.getPlanName());
        plan.setDescription(planDto.getDescription());
        plan.setPlanType(planDto.getPlanType());
        plan.setEligibilityCriteria(planDto.getEligibilityCriteria());

        planRepository.save(plan);
        return plan.getPlanNo();
    }

    @Transactional(readOnly = true)
    public PlanDto findPlan(int planNo) {
        Plan plan = planRepository.findById(planNo).get();
        return PlanDto.of().planNo(plan.getPlanNo())
                .planName(plan.getPlanName())
                .description(plan.getDescription())
                .planType(plan.getPlanType())
                .eligibilityCriteria(plan.getEligibilityCriteria()).build();
    }


    public List<PlanDto> findAll(String sortColumn) {
        return planRepository.findAll(Sort.by(sortColumn).ascending()).stream().map(PlanService::toPlanDto
        ).collect(Collectors.toList());
    }

    public List<PlanDto> findAll(int pageNo, int pageSize) {
        return planRepository.findAll(Pageable.ofSize(pageSize).withPage(pageNo))
                .stream()
                .map(PlanService::toPlanDto)
                .collect(Collectors.toList());
    }

    public List<PlanDto> findPlansByPlanType(String planType) {
        return planRepository.findByPlanTypeLike(planType).stream()
                .map(PlanService::toPlanDto)
                .collect(Collectors.toList());
    }

    public long findNoOfPlansByPlanType(String planType) {
        return planRepository.countByPlanType(planType);
    }

    @Transactional(readOnly = false)
    public int updatePlanEligibilityByPlanType(String eligibilityCriteria, String planType) {
        return planRepository.updateEligibilityCriteraByPlanType(planType, eligibilityCriteria);
    }

    private static PlanDto toPlanDto(Plan plan) {
        return PlanDto.of().planNo(plan.getPlanNo())
                .planName(plan.getPlanName())
                .description(plan.getDescription())
                .planType(plan.getPlanType())
                .eligibilityCriteria(plan.getEligibilityCriteria()).build();
    }
}















