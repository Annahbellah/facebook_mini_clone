package dev.decagon.facebookcloneapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionInitializer {
    public static Connection connection;
    private UserRepositoryImpl userRepository;
    private static String driver="com.mysql.cj.jdbc.Driver";
    private static String url= "jdbc:mysql://localhost:3306/facebook_clone_app";
    private static String username=       "root";
    private  static String dbPassword=        "OC@log4.2";

    public  static Connection getConnected(){
        try {
            connection= ConnectionInitializer.connectToDB(driver,url,username,dbPassword);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }


    public static Connection connectToDB(String driverClassname, String connectionString, String username, String password)
            throws ClassNotFoundException, SQLException {
        Class.forName(driverClassname);
        return DriverManager.getConnection(connectionString,username,password);
    }

    public  static Boolean closeDBConnection(Connection connection){
        try {
            connection.close();
            return  true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
