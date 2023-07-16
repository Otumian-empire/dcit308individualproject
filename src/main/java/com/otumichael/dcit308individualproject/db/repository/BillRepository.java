package com.otumichael.dcit308individualproject.db.repository;

import com.otumichael.dcit308individualproject.db.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BillRepository {
    private final Connection connection;

    public BillRepository() throws SQLException {
        connection = Database.connection();
    }

    public void insertBill(String name, int quantity, int price, String customerName) throws SQLException {
        String sql = "INSERT INTO `bill`(`goodId`, `quantity`, `price`, `customerId`) " +
                "VALUES(" +
                "(SELECT id FROM good WHERE `name` = ? LIMIT 1)," +
                " ?," +
                " ?," +
                "(SELECT id FROM customer WHERE `name` = ? LIMIT 1));";

        // Create a prepared statement
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            // Set the parameters of the prepared statement
            statement.setString(1, name);
            statement.setInt(2, quantity);
            statement.setInt(3, price);
            statement.setString(4, customerName);

            statement.executeUpdate();
            connection.close();
        }
    }
}
