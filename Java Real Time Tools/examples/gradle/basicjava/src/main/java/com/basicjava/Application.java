package com.basicjava;

import com.basicjava.dao.AccountDao;

import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        AccountDao dao = new AccountDao();
        dao.showAllAccounts();
    }
}
