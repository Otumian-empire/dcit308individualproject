package com.otumichael.dcit308individualproject.db.repository;

import com.otumichael.dcit308individualproject.db.Database;
import com.otumichael.dcit308individualproject.mapper.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    private final Connection connection;

    public CustomerRepository() throws SQLException {
        connection = Database.connection();
    }

    public List<Customer> getCustomers() throws SQLException {
        List<Customer> customers = new ArrayList<>();

        Statement statement = connection.createStatement();
        String sql = "SELECT `id`, `name`, `email` FROM `customer`;";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = Integer.parseInt(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");

            customers.add(new Customer(id, name, email));
        }

        return customers;
    }

    public int getCustomerIdByName(String name) throws SQLException {
        String sql = "SELECT id FROM customer where name=?;";
        PreparedStatement statement = connection.prepareStatement(sql);

        // Set the parameters of the prepared statement
        statement.setString(1, name);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            return resultSet.getInt("id");
        }

        resultSet.close();
        return -1;
    }
}
