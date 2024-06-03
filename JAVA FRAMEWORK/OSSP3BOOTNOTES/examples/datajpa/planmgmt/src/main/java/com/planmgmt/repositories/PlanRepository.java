package com.planmgmt.repositories;

import com.planmgmt.entities.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Integer> {
    List<Plan> findByPlanTypeLike(String planType);
    long countByPlanType(String planType);

    @Modifying
    @Query("update Plan p set p.eligibilityCriteria=?2 where p.planType=?1")
    int updateEligibilityCriteraByPlanType(String planType, String eligibilityCriteria);


}
