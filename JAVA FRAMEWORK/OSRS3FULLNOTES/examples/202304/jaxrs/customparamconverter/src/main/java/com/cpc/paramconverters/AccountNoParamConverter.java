package com.cpc.paramconverters;

import com.cpc.dto.AccountNo;
import jakarta.ws.rs.ext.ParamConverter;

public class AccountNoParamConverter implements ParamConverter<AccountNo> {
    @Override
    public AccountNo fromString(String value) {
        System.out.println("fromString(" + value + ")");
        AccountNo accountNo = new AccountNo();
        accountNo.setZoneId(value.substring(0, 5));
        accountNo.setType(value.substring(5, 7));
        accountNo.setUniqueNumber(Integer.parseInt(value.substring(7, 12)));
        return accountNo;
    }

    @Override
    public String toString(AccountNo accountNo) {
        return accountNo.getZoneId() + accountNo.getType() + accountNo.getUniqueNumber();
    }
}
