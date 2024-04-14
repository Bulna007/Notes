package com.bt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/index.htm")
    public String showIndexPage(Model model) {
        model.addAttribute("message", "Welcome to Thymeleaf!");
        return "index";
    }
}
