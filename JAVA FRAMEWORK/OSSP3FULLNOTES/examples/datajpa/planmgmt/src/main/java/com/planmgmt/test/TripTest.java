package com.planmgmt.test;

import com.planmgmt.config.RootConfig;
import com.planmgmt.entities.Trip;
import com.planmgmt.entities.TripSummary;
import com.planmgmt.repositories.TripRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class TripTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(RootConfig.class);
        TripRepository tripRepository = applicationContext.getBean("tripRepository", TripRepository.class);

        //tripRepository.findByDaysGreaterThanEqual(5).forEach(System.out::println);
        //tripRepository.findByTripCostBetween(35000, 100000).forEach(System.out::println);
        //tripRepository.findByTripNameContaining("Holiday").forEach(System.out::println);


        //tripRepository.findBySourceNotIn(Arrays.asList("Mumbai", "New Delhi")).forEach(System.out::println);
        //tripRepository.findBySourceLikeAndDestinationLike("Hyderabad", "New Delhi").forEach(System.out::println);

        //tripRepository.getTripsByDaysAndCost(5, 150000).forEach(System.out::println);
        //tripRepository.getTripsByDaysBetween(4, 10).forEach(System.out::println);
        //int r = tripRepository.updateTripDaysBySource("Hyderabad", 10);

//        tripRepository.findByDaysGreaterThan(5).forEach(ts->{
//            System.out.println(ts.getTripName() + " : " + ts.getTripCost());
//        });

//        tripRepository.findByStartDateGreaterThanAndEndDateLessThan(LocalDate.of(2023, 06, 01),
//                LocalDate.of(2023, 12, 31)).forEach(ts -> {
//            System.out.println(ts.getTourName() + " - " + ts.getPlannedStartDate() + " - "+ ts.getApproximateEndDate());
//        });

//        tripRepository.findBySourceLike("Hyderabad").forEach(td->{
//            System.out.println(td.getClass().getName());
//        });
        List<TripSummary> tripSummaries = tripRepository.findByTripNameLike("Holiday%", TripSummary.class);
        tripSummaries.forEach(ts->{
            System.out.println(ts.getTripName());
        });
    }
}
