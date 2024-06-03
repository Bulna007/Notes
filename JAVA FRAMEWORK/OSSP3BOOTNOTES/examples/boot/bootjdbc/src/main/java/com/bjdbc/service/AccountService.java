package com.bjdbc.service;

import com.bjdbc.dao.AccountDao;
import com.bjdbc.dto.AccountDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountService {
    private final AccountDao accountDao;

    @Transactional(readOnly = true)
    public List<AccountDto> getAllAccounts() {
        return accountDao.findAll().stream().map(bo -> {
            return AccountDto.of().accountNo(bo.getAccountNo())
                    .accountHolderName(bo.getAccountHolderName())
                    .balance(bo.getBalance()).build();
        }).toList();
    }
}
