package com.ab.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trainStatus")
public class TrainStatusApiController {

    @GetMapping(produces = {MediaType.TEXT_PLAIN_VALUE})
    public String trainStatus(@RequestParam("trainNo") String trainNo) {
        return "Train No : " + trainNo + " Running on-time";
    }
}
