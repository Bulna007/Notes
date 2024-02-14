package com.bwjpa.entities;

import com.bwjpa.dto.AccountDto;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "account")
@Data
public class Account implements Serializable {
    @Id
    @Column(name = "account_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountNo;
    @Column(name = "account_holder_nm")
    private String accountHolderName;
    @Column(name = "account_type")
    private String accountType;
    @Column(name = "ifsc_code")
    private String ifscCode;
    private double balance;

    public static AccountDto toAccountDto(Account account) {
        return AccountDto.of()
                .accountNo(account.getAccountNo())
                .accountHolderName(account.getAccountHolderName())
                .balance(account.getBalance())
                .build();
    }
}
