package com.bjdbc.dao;

import com.bjdbc.bo.AccountBo;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class AccountDao {
    private final String SQL_GET_ALL_ACCOUNTS = "select account_no, account_holder_nm, account_type, ifsc_code, balance from account";
    private final JdbcTemplate jdbcTemplate;

    public List<AccountBo> findAll() {
        return jdbcTemplate.query(SQL_GET_ALL_ACCOUNTS, (rs, rowNum) -> {
            return AccountBo.of().accountNo(rs.getInt(1))
                    .accountHolderName(rs.getString(2))
                    .accountType(rs.getString(3))
                    .ifscCode(rs.getString(4))
                    .balance(rs.getDouble(5)).build();
        });
    }
}
