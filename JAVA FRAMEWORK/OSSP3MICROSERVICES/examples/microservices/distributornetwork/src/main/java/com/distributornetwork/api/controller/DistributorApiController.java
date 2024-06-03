package com.distributornetwork.api.controller;

import com.distributornetwork.bean.NetworkSettings;
import com.distributornetwork.dto.Distributor;
import com.distributornetwork.exception.NotFoundException;
import com.distributornetwork.service.DistributorService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/distributor")
public class DistributorApiController {
    private final DistributorService distributorService;
    private final NetworkSettings networkSettings;


    @GetMapping(value = "/{distributorCode}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Distributor getDistributor(@PathVariable("distributorCode") String distributorCode, HttpServletRequest httpServletRequest) {
        httpServletRequest.getHeaderNames().asIterator().forEachRemaining(hn->{
            System.out.println(hn + ":"+ httpServletRequest.getHeader(hn));
        });
        return distributorService.findDistributorByDistributorCode(distributorCode);
    }

    @GetMapping("/networksettings")
    public NetworkSettings getNetworkSettings() {
        return networkSettings;
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException e) {
        return ResponseEntity.of(ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(404), "distributor not found")).build();
    }
}
