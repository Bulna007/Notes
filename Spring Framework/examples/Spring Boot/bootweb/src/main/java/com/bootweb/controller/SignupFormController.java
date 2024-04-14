package com.bootweb.controller;

import com.bootweb.form.SignupForm;
import com.bootweb.validator.SignupFormValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/signup")
public class SignupFormController {
    @Autowired
    private SignupFormValidator signupFormValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(signupFormValidator);
    }

    @GetMapping
    public String showSignupPage(Model model) {
        SignupForm signupForm = new SignupForm();
        model.addAttribute("signupForm",signupForm);
        return "signup";
    }

    @PostMapping
    public String doSignUp(@ModelAttribute("signupForm") @Valid SignupForm signupForm, BindingResult errors, Model model) {

        if(errors.hasErrors()) {
            return "signup";
        }
        System.out.println("storing the account data into db, and creating the account...");
        model.addAttribute("emailAddress", signupForm.getEmailAddress());

        return "signup-finished";
    }
}
