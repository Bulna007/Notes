package com.sfjbv.controller;

import com.sfjbv.form.LoanApplicationForm;
import com.sfjbv.validator.LoanApplicationFormValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/applyLoan.htm")
public class LoanFormController {
    @Autowired
    private LoanApplicationFormValidator loanApplicationFormValidator;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.addValidators(loanApplicationFormValidator);
    }

    @GetMapping
    public String setupForm(ModelMap modelMap) {
        LoanApplicationForm form = new LoanApplicationForm();
        modelMap.addAttribute("loanApplicationForm", form);
        return "apply-loan";
    }

    @PostMapping
    public String applyLoan(@ModelAttribute("loanApplicationForm") @Valid LoanApplicationForm form,
                            BindingResult errors, ModelMap modelMap) {

        if (errors.hasErrors()) {
            return "apply-loan";
        }
        System.out.println("performing business logic....");

        modelMap.addAttribute("refNo", UUID.randomUUID().toString().substring(0, 12));
        return "apply-loan-success";
    }
}
