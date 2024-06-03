package com.rww.controller;

import com.rww.dto.TrainDto;
import com.rww.form.SearchTrainsForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class TrainController {
    @RequestMapping("/findAvailableTrains.htm")
    public String findAvailableTrains(@ModelAttribute("searchTrainsForm") SearchTrainsForm form, Model model) {
        List<TrainDto> availableTrains = null;
        SecureRandom random = new SecureRandom();

        availableTrains = IntStream.range(1000, 1010).mapToObj(trainNo-> {
            TrainDto dto = TrainDto.of().trainNo(trainNo).source(form.getSource()).destination(form.getDestination())
                    .trainType(form.getTrainType()).duration(random.nextInt(50))
                    .arrivalTime(String.valueOf(random.nextInt(12)+ ":"+random.nextInt(59)))
                    .departureTime(String.valueOf(random.nextInt(12)+ ":"+random.nextInt(59))).build();
            return dto;
        }).collect(Collectors.toList());


        model.addAttribute("availableTrains", availableTrains);
        return "available-trains";
    }
}
