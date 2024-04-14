package com.bt.controller;

import com.bt.form.SignUpForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup.htm")
public class SignupFormController {

    @GetMapping
    public String showSignupForm(Model model) {
        model.addAttribute("signUpForm", new SignUpForm());
        return "signup";
    }

    @PostMapping
    public String doSignup(@ModelAttribute("signUpForm") @Valid SignUpForm signUpForm, BindingResult errors, Model model) {
        if(errors.hasErrors()) {
            return "signup";
        }
        model.addAttribute("username", signUpForm.getUsername());

        return "signup-success.html";
    }
}
