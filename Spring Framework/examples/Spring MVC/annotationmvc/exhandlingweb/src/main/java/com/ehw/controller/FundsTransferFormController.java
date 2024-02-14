package com.ehw.controller;


import com.ehw.exception.DormantAccountException;
import com.ehw.exception.LimitExceededException;
import com.ehw.form.FundsTransferForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping("/fundsTransfer.htm")
public class FundsTransferFormController {
    @GetMapping
    public String setupForm(ModelMap modelMap) {
        FundsTransferForm form = new FundsTransferForm();
        modelMap.addAttribute("fundsTransferForm", form);
        return "funds-transfer";
    }

    @PostMapping
    public String transferFunds(@ModelAttribute("fundsTransferForm") @Valid FundsTransferForm form,
                                BindingResult errors, ModelMap modelMap) {
        if (errors.hasErrors()) {
            return "funds-transfer";
        }
        // throwing dummy exceptions to show error handling capabilities
        if (form.getFromAccount().startsWith("D")) {
            throw new DormantAccountException("Account is closed");
        }
        if (form.getAmount() > 50000) {
            throw new LimitExceededException("Insufficient funds");
        }
        modelMap.addAttribute("refNo", UUID.randomUUID().toString().substring(0, 19));
        return "tx-details";
    }

}
