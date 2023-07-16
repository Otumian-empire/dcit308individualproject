package com.otumichael.dcit308individualproject.db.repository;

import com.otumichael.dcit308individualproject.db.Database;
import com.otumichael.dcit308individualproject.mapper.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IssueGoodRepository {

    private final Connection connection;

    public IssueGoodRepository() throws SQLException {
        connection = Database.connection();
    }

    public void insertIssueGood(String goodName, int quantity, String customerName) throws SQLException {
        String sql = "INSERT INTO `issued_good`(`goodId`, `quantity`, `customerId`) " +
                "VALUES(( SELECT id FROM good WHERE NAME = ? LIMIT 1 )," +
                " ?, " +
                "(SELECT id FROM customer WHERE NAME = ? LIMIT 1 ));";

        // Create a prepared statement
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            // Set the parameters of the prepared statement
            statement.setString(1, goodName);
            statement.setInt(2, quantity);
            statement.setString(3, customerName);

            // Execute the prepared statement
            statement.executeUpdate();
        }
    }

    public List<IssuedGood> getIssueGoods() throws SQLException {
        List<IssuedGood> issuedGoods = new ArrayList<>();


        Statement statement = connection.createStatement();
        String sql = "SELECT issued_good.id AS issuedGoodId, " +
                "good.name AS goodName, " +
                "issued_good.quantity AS issuedGoodQuantity, " +
                "issued_good.dateIssued AS issuedGoodDate, " +
                "customer.name AS customerName " +
                "FROM issued_good " +
                "INNER JOIN good ON issued_good.goodId = good.id " +
                "INNER JOIN customer ON issued_good.customerId = customer.id " +
                "ORDER BY issued_good.id ASC;";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            // get customer
            String customerName = resultSet.getString("customerName");

            // get good
            String goodName = resultSet.getString("goodName");

            // get issue good
            int issueGoodId = resultSet.getInt("issuedGoodId");
            int issuedGoodQuantity = resultSet.getInt("issuedGoodQuantity");
            String issuedGoodDate = resultSet.getString("issuedGoodDate");

            Vendor vendor = new Vendor(-1, "", "");
            Category category = new Category(-1, "");
            Good good = new Good(-1, goodName, -1, -1, category, vendor, "");
            Customer customer = new Customer(-1, customerName, "");
            IssuedGood issuedGood = new IssuedGood(issueGoodId, good, issuedGoodQuantity, issuedGoodDate, customer);

            issuedGoods.add(issuedGood);
        }

        return issuedGoods;
    }

}
