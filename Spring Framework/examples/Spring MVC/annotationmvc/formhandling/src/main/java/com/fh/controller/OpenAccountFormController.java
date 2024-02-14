package com.fh.controller;

import com.fh.dto.AccountDto;
import com.fh.form.OpenAccountForm;
import com.fh.validator.OpenAccountFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

@Controller
@RequestMapping("/openaccount.htm")
public class OpenAccountFormController {
    @Autowired
    private OpenAccountFormValidator validator;

    @RequestMapping(method = RequestMethod.GET)
    public String showOpenAccountFormPage(ModelMap modelMap) {
        OpenAccountForm form = new OpenAccountForm();
        modelMap.addAttribute("openAccountForm", form);
        return "open-account";
    }


    @RequestMapping(method = RequestMethod.POST)
    public String openAccount(@ModelAttribute("openAccountForm") OpenAccountForm openAccountForm, BindingResult errors, ModelMap modelMap) {
        AccountDto accountDto = null;

        if (validator.supports(openAccountForm.getClass())) {
            validator.validate(openAccountForm, errors);
        }
        if (errors.hasErrors()) {
            return "open-account";
        }

        // insert the data into database and generate accountNo
        accountDto = AccountDto.of().accountNo(UUID.randomUUID().toString().substring(1, 12))
                .accountHolderName(openAccountForm.getFirstName() + " " + openAccountForm.getLastName())
                .branchName("Kukatpally")
                .ifscCode("HDFC000029")
                .status("Active").build();
        modelMap.addAttribute("account", accountDto);

        return "account-details";
    }

}



















