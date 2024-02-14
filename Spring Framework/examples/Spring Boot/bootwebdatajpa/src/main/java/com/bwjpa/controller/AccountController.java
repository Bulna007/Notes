package com.bwjpa.controller;

import com.bwjpa.dto.AccountDto;
import com.bwjpa.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/accounts")
    public String showAccounts(Model model) {
        List<AccountDto> accountDtos = accountService.getAccounts();
        model.addAttribute("accounts", accountDtos);

        return "all-accounts";
    }
}
