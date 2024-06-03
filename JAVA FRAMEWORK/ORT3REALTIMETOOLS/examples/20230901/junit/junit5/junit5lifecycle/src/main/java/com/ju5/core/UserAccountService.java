package com.ju5.core;

import com.ju5.bean.UserAccount;

import java.security.SecureRandom;

public class UserAccountService {
    public int registerUser(UserAccount userAccount) {
        return new SecureRandom().nextInt(65535);
    }
}
