package com.courage.fbclone.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionInitializer {

    public static Connection connectToDB(String driverClassname, String connectionString, String username, String password)
            throws ClassNotFoundException, SQLException {
        Class.forName(driverClassname);
        return DriverManager.getConnection(connectionString,username,password);
    }
}
