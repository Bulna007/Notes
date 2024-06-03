package com.acp.controller;

import com.acp.dto.TicketDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.Map;

@Controller
public class TicketController {

    //@RequestMapping("/getPNRStatus.htm")
    public ModelAndView pnrStatus(HttpServletRequest httpServletRequest) {
        String pnrNo = httpServletRequest.getParameter("pnrNo");

        TicketDto ticketDto = TicketDto.of().pnrNo(pnrNo).passengerName("Paul Stout").source("New Delhi")
                .destination("Gurgoan").travelDate(LocalDate.now())
                .coach("B1").berth(23).status("CNF").build();

        ModelAndView mav = new ModelAndView();
        mav.setViewName("ticket-details");
        mav.addObject("ticket", ticketDto);

        return mav;
    }

    @RequestMapping("/getPNRStatus.htm")
    public String pnrStatus(WebRequest webRequest, Map<String, Object> modelMap) {
        String pnrNo = webRequest.getParameter("pnrNo");

        TicketDto ticketDto = TicketDto.of().pnrNo(pnrNo).passengerName("Paul Stout").source("New Delhi")
                .destination("Gurgoan").travelDate(LocalDate.now())
                .coach("B1").berth(23).status("CNF").build();

        modelMap.put("ticket", ticketDto);
        return "ticket-details";
    }
}

















