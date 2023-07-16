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
        CategoryRepository categoryRepository = new CategoryRepository();
        int categoryId = categoryRepository.getCategoryIdByName(categoryName);

        VendorRepository vendorRepository = new VendorRepository();
        int vendorId = vendorRepository.getVendorIdByName(vendorName);

        // INSERT INTO `good`(`id`, `name`, `quantity`, `price`, `categoryId`, `vendorId`, `description`)
        // VALUES ('[value-1]','[value-2]','[value-3]','[value-4]','[value-5]','[value-6]','[value-7]')

        String sql = "INSERT INTO good (name, price, quantity, categoryId, vendorId, description) ";
        sql += "VALUES (?, ?, ?, ?, ?, ?)";

        // Create a prepared statement
        PreparedStatement statement = connection.prepareStatement(sql);

        // Set the parameters of the prepared statement
        statement.setString(1, name);
        statement.setInt(2, price);
        statement.setInt(3, quantity);
        statement.setInt(4, categoryId);
        statement.setInt(5, vendorId);
        statement.setString(6, description);

        // Execute the prepared statement
        int rowsAffected = statement.executeUpdate();

        // Close the connection
        connection.close();

        // Print the number of rows affected
        System.out.println("Rows affected: " + rowsAffected);
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

        ResultSet resultSet = statement.executeQuery(sql);

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

        connection.close();
        return goods;
    }

    // update goods and create a new issued goods

}
