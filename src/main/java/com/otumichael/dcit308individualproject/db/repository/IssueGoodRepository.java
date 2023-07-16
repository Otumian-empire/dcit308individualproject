package com.otumichael.dcit308individualproject.db.repository;

import com.otumichael.dcit308individualproject.db.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IssueGoodRepository {

    private final Connection connection;

    public IssueGoodRepository() throws SQLException {
        connection = Database.connection();
    }

    public void insertIssueGood(String goodName, int quantity, String customerName) throws SQLException {

        // get the id of good by name
        // we have the quantity
        // get the id of the customer by name

        String sql = "INSERT INTO `issued_good`(`goodId`, `quantity`, `customerId`) " +
                "VALUES(( SELECT id FROM good WHERE NAME = ? LIMIT 1 )," +
                " ?, " +
                "(SELECT id FROM customer WHERE NAME = ? LIMIT 1 ));";

        // Create a prepared statement
        PreparedStatement statement = connection.prepareStatement(sql);

        // Set the parameters of the prepared statement
        statement.setString(1, goodName);
        statement.setInt(2, quantity);
        statement.setString(3, customerName);

        // Execute the prepared statement
        int rowsAffected = statement.executeUpdate();

        // Close the connection
        connection.close();

        // Print the number of rows affected
        System.out.println("Rows affected: " + rowsAffected);
    }
}
