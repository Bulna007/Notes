package com.bwjpa.service;

import com.bwjpa.dto.AccountDto;
import com.bwjpa.entities.Account;
import com.bwjpa.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    @Transactional(readOnly = true)
    public List<AccountDto> getAccounts() {
        return accountRepository.findAll().stream().map(Account::toAccountDto).toList();
    }
}
