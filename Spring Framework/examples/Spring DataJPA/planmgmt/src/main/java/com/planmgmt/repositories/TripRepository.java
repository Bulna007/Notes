package com.planmgmt.repositories;

import com.planmgmt.entities.Trip;
import com.planmgmt.entities.TripDetails;
import com.planmgmt.entities.TripSchedule;
import com.planmgmt.entities.TripSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Integer> {
    List<Trip> findByDaysGreaterThanEqual(int days);

    List<Trip> findByTripCostBetween(double minTripCost, double maxTripCost);

    List<Trip> findByTripNameContaining(String tripName);

    List<Trip> findBySourceNotIn(List<String> sources);

    List<Trip> findBySourceLikeAndDestinationLike(String source, String destination);

    @Query("from Trip t where t.days >= ?1 and t.tripCost >= ?2")
    List<Trip> getTripsByDaysAndCost(int days, double cost);

    @Query("from Trip t where t.days between :minDays and :maxDays")
    List<Trip> getTripsByDaysBetween(@Param("minDays") int minDays, @Param("maxDays") int maxDays);

    @Modifying
    @Query("update Trip t set t.days = ?2 where t.source=?1")
    int updateTripDaysBySource(String source, int days);

    List<TripSummary> findByDaysGreaterThan(int days);

    List<TripSchedule> findByStartDateGreaterThanAndEndDateLessThan(LocalDate startDate, LocalDate endDate);

    List<TripDetails> findBySourceLike(String source);

    <T> List<T> findByTripNameLike(String tripName, Class<T> classType);
}
















