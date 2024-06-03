package com.bacw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OurClientsController {

    @RequestMapping("/our-clients.htm")
    public String showOurClientsPage() {
        return "our-clients";
    }
}
