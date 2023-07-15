package com.otumichael.dcit308individualproject.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {

    public static Connection connection() throws SQLException {
        String connectionString = "jdbc:mysql://localhost/dcit_308_inventory_management_system_db?user=root&password=";

        Connection   connection = DriverManager.getConnection(connectionString);
        System.out.println("Db connected successfully");

        return connection;
    }
}