package com.courage.fbclone.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public interface BaseRepository<T,K> {
    T getById(K k);
    List<T> getAll();
    Boolean save(T t);
    T update(T t);
    Boolean delete(T t);

    static Connection connectToDB(String driverClassname, String connectionString,String username, String password)
            throws ClassNotFoundException, SQLException {
            Class.forName(driverClassname);
            return DriverManager.getConnection(connectionString,username,password);
    }
}
