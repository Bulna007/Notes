package com.college360.helper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionHelper {
    private static Properties dbProperties;

    static {
        try {
            dbProperties = new Properties();
            dbProperties.load(ConnectionHelper.class.getClassLoader().getResourceAsStream("db.properties"));
            Class.forName(dbProperties.getProperty("db.driverClassName"));
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("failed in loading db properties", e);
        }
    }

    public static Connection newConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(dbProperties.getProperty("db.url"),
                    dbProperties.getProperty("db.username"), dbProperties.getProperty("db.password"));
            con.setAutoCommit(false);
        } catch (Exception e) {
            throw new RuntimeException("failed while creating connection", e);
        }
        return con;
    }
}
