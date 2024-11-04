package com.iudigital.funcionariocrud.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionUtil {
    private static final String URL = "jdbc:postgresql://localhost:5432/iu_digital_funcionarios";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Jose2003";
    
    public static Connection getConnection()throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
