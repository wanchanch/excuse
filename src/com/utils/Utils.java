package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utils {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    static {
        driver = "com.mysql.cj.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/excuse?allowPublicKeyRetrieval=true&useSSL=false";
        username = "root";
        password = "279980";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }
}


