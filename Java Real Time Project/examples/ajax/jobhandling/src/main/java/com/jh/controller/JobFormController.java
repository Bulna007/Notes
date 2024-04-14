package com.jh.controller;

import com.jh.dto.ProfessionDto;
import com.jh.dto.SpecializationDto;
import com.jh.form.JobForm;
import com.jh.service.JobService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/job")
@AllArgsConstructor
public class JobFormController {
    private final JobService jobService;

    @GetMapping
    public String setupForm(Model model) {
        JobForm jobForm = new JobForm();
        model.addAttribute("newJobForm", jobForm);
        return "newjob";
    }

    @ModelAttribute("professions")
    public List<ProfessionDto> populateProfessions() {
        return jobService.getAllProfessions();
    }

    @GetMapping(value = "{professionId}/specializations", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<SpecializationDto> fetchSpecializationsByProfession(
            @PathVariable("professionId") String professionId) {
        return jobService.getSpecializationsByProfession(Integer.parseInt(professionId));
    }

    @PostMapping
    public String postJob(@ModelAttribute("newJobForm") JobForm jobForm, BindingResult errors) {
        return "jobdetails";
    }

}
