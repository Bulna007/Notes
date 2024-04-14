package com.jh.repository;

import com.jh.entities.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecializationRepository extends JpaRepository<Specialization, Integer> {
    @Query(value = "from Specialization s where s.profession.professionId=:professionId")
    List<Specialization> getSpecializationsByProfessionId(@Param("professionId") int professionId);
}
