package com.otumichael.dcit308individualproject.db.repository;

import com.otumichael.dcit308individualproject.db.Database;
import com.otumichael.dcit308individualproject.mapper.Vendor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendorRepository {
    private final Connection connection;

    public VendorRepository() throws SQLException {
        connection = Database.connection();
    }

    public List<Vendor> getVendors() throws SQLException {
        List<Vendor> vendors = new ArrayList<>();

        Statement statement = connection.createStatement();
        String sql = "SELECT `id`, `name`, `email` FROM `vendor`;";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = Integer.parseInt(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");

            vendors.add(new Vendor(id, name, email));
        }

        return vendors;
    }

    public int getVendorIdByName(String name) throws SQLException {
        String sql = "SELECT id FROM vendor where name=?;";
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
