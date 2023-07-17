package com.otumichael.dcit308individualproject.db.repository;

import com.otumichael.dcit308individualproject.db.Database;
import com.otumichael.dcit308individualproject.mapper.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {
    private final Connection connection;

    public CategoryRepository() throws SQLException {
        connection = Database.connection();
    }

    public List<Category> getCategories() throws SQLException {
        List<Category> categories = new ArrayList<>();

        Statement statement = connection.createStatement();
        String sql = "SELECT id, name FROM category;";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = Integer.parseInt(resultSet.getString("id"));
            String name = resultSet.getString("name");

            categories.add(new Category(id, name));
        }

        return categories;
    }

    public int getCategoryIdByName(String name) throws SQLException {
        String sql = "SELECT id FROM category where name=?;";
        PreparedStatement statement = connection.prepareStatement(sql);

        // Set the parameters of the prepared statement
        statement.setString(1, name);

        ResultSet resultSet = statement.executeQuery();

        int id = -1;
        if (resultSet.next()) {
            id = resultSet.getInt("id");
        }

        return id;
    }
}