package com.bt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"personName"})
public class WelcomeController {

    @GetMapping("/welcome.htm")
    public String welcomePage(Model model) {
        model.addAttribute("personName", "Harley");
        return "welcome";
    }
}
