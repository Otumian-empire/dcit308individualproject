package com.otumichael.dcit308individualproject.db.repository;

import com.otumichael.dcit308individualproject.db.Database;
import com.otumichael.dcit308individualproject.mapper.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillRepository {
    private final Connection connection;

    public BillRepository() throws SQLException {
        connection = Database.connection();
    }

    public void insertBill(String name, int quantity, int price, String customerName) throws SQLException {
        String sql = "INSERT INTO `bill`(`goodId`, `quantity`, `price`, `customerId`) "
                + "VALUES("
                + "(SELECT id FROM good WHERE `name` = ? LIMIT 1),"
                + " ?,"
                + " ?,"
                + "(SELECT id FROM customer WHERE `name` = ? LIMIT 1));";

        // Create a prepared statement
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            // Set the parameters of the prepared statement
            statement.setString(1, name);
            statement.setInt(2, quantity);
            statement.setInt(3, price);
            statement.setString(4, customerName);

            statement.executeUpdate();
        }

    }


    public List<Bill> getBills() throws SQLException {
        List<Bill> bills = new ArrayList<>();

        // SELECT good.id AS goodId, good.name AS goodName, good.quantity AS goodQuantity, good.price AS goodPrice,
        // category.id AS categoryId, category.name AS categoryName, vendor.id AS vendorId,
        // vendor.name AS vendorName, vendor.email AS vendorEmail FROM good
        // INNER JOIN category ON good.categoryId = category.id
        // INNER JOIN vendor ON good.vendorId = vendor.id ORDER BY good.id;
        Statement statement = connection.createStatement();
        String sql = "SELECT `bill`.`id` AS `billId`, " + "`good`.`name` AS `goodName`, " + "`bill`.`quantity` AS `billQuantity`, " + "`bill`.`price` AS `billPrice`, " + "`bill`.`dateBilled` AS `billDate`, " + "`customer`.`name` AS `customerName`" + " FROM `bill` " + "INNER JOIN `good` ON `good`.`id` = `bill`.`goodId` " + "INNER JOIN `customer` ON `customer`.`id` = `bill`.`customerId`; ";

        try (ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {

                int billId = resultSet.getInt("billId");
                String goodName = resultSet.getString("goodName");
                int billQuantity = resultSet.getInt("billQuantity");
                int billPrice = resultSet.getInt("billPrice");
                String billDate = resultSet.getString("billDate");
                String customerName = resultSet.getString("customerName");

                Vendor vendor = new Vendor(-1, "", "");
                Category category = new Category(-1, "");
                Good good = new Good(-1, goodName, -1, -1, category, vendor, "");
                Customer customer = new Customer(-1, customerName, "");

                bills.add(new Bill(billId, good, billQuantity, billPrice, billDate, customer));
            }
        }

        return bills;
    }
}
