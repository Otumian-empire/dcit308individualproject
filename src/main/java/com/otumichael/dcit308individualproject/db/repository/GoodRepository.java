package com.otumichael.dcit308individualproject.db.repository;

import com.otumichael.dcit308individualproject.db.Database;
import com.otumichael.dcit308individualproject.mapper.Category;
import com.otumichael.dcit308individualproject.mapper.Good;
import com.otumichael.dcit308individualproject.mapper.Vendor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoodRepository {
    private final Connection connection;

    public GoodRepository() throws SQLException {
        connection = Database.connection();
    }

    public void insertGood(String name, int price, int quantity, String categoryName, String vendorName, String description) throws SQLException {

        if (this.isExistingGood(name)) {
            throw new SQLException("It seems a item with the same name already exist");
        }

        String sql = "INSERT INTO good(`name`, `price`, `quantity`, `categoryId`, `vendorId`, `description`) " + "VALUES(" + "   ?, ?, ?, " + "   (SELECT `id` FROM `category` WHERE `name` = ? LIMIT 1), " + "   (SELECT `id` FROM `vendor` WHERE `name` = ? LIMIT 1), " + "   ?" + ");";

        // Create a prepared statement
        PreparedStatement statement = connection.prepareStatement(sql);

        // Set the parameters of the prepared statement
        statement.setString(1, name);
        statement.setInt(2, price);
        statement.setInt(3, quantity);
        statement.setString(4, categoryName);
        statement.setString(5, vendorName);
        statement.setString(6, description);

        // Execute the prepared statement
        statement.executeUpdate();

        // Close the connection
        connection.close();
    }

    public List<Good> getGoods() throws SQLException {
        List<Good> goods = new ArrayList<>();

        // SELECT good.id AS goodId, good.name AS goodName, good.quantity AS goodQuantity, good.price AS goodPrice,
        // category.id AS categoryId, category.name AS categoryName, vendor.id AS vendorId,
        // vendor.name AS vendorName, vendor.email AS vendorEmail FROM good
        // INNER JOIN category ON good.categoryId = category.id
        // INNER JOIN vendor ON good.vendorId = vendor.id ORDER BY good.id;
        Statement statement = connection.createStatement();
        String sql = "SELECT good.id AS goodId, good.name AS goodName, good.quantity AS goodQuantity, good.price AS goodPrice, ";
        sql += " good.description as goodDescription, category.id AS categoryId, category.name AS categoryName, vendor.id AS vendorId, ";
        sql += "vendor.name AS vendorName, vendor.email AS vendorEmail FROM good ";
        sql += "INNER JOIN category ON good.categoryId = category.id ";
        sql += "INNER JOIN vendor ON good.vendorId = vendor.id ORDER BY good.id;";

        try (ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                // get category
                int categoryId = resultSet.getInt("categoryId");
                String categoryName = resultSet.getString("categoryName");

                // get vendor
                int vendorId = resultSet.getInt("vendorId");
                String vendorName = resultSet.getString("vendorName");
                String vendorEmail = resultSet.getString("vendorEmail");

                // get good
                int goodId = resultSet.getInt("goodId");
                String goodName = resultSet.getString("goodName");
                int goodQuantity = resultSet.getInt("goodQuantity");
                int goodPrice = resultSet.getInt("goodPrice");
                Category category = new Category(categoryId, categoryName);
                Vendor vendor = new Vendor(vendorId, vendorName, vendorEmail);
                String goodDescription = resultSet.getString("goodDescription");

                goods.add(new Good(goodId, goodName, goodPrice, goodQuantity, category, vendor, goodDescription));
            }

        }


        connection.close();
        return goods;
    }


    public boolean isExistingGood(String name) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("SELECT COUNT(id) AS goodCount FROM good WHERE name = ?; ")) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            boolean exists = false;
            while (resultSet.next()) {
                int count = resultSet.getInt("goodCount");
                exists = count > 0;
            }

            return exists;
        }
    }

    public Good getGood(String name) throws SQLException {
        String sql = "SELECT id, price, quantity FROM good WHERE name = ? LIMIT 1; ";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                int price = resultSet.getInt("price");
                int quantity = resultSet.getInt("quantity");

                Category category = new Category(-1, "");
                Vendor vendor = new Vendor(-1, "", "");

                return new Good(
                        id,
                        "",
                        price,
                        quantity,
                        category,
                        vendor,
                        ""
                );
            }
        }

        throw new SQLException("There is no item with such name");
    }

    // update goods and create a new issued goods
    public void updateGoodQuantity(int id, int newQuantity) throws SQLException {
        String sql = "UPDATE `good` SET `quantity`= ? WHERE `id`=?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, newQuantity);
            statement.setInt(2, id);
            statement.executeUpdate();
        }
    }

}
