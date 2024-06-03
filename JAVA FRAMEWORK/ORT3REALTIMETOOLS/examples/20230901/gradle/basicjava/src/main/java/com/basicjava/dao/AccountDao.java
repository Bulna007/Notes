package com.basicjava.dao;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class AccountDao {
    public void showAllAccounts() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver"); // loading dynamically at runtime
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hibdb", "root", "welcome1");
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from account");

        while(resultSet.next()) {
            System.out.println("account no: "+ resultSet.getInt(1) + " , account holder name : " + resultSet.getString(2));
        }
        resultSet.close();
        statement.close();
        con.close();
    }
}
