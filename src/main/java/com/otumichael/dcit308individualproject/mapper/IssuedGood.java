package com.otumichael.dcit308individualproject.mapper;

public class IssuedGood {
    //    id, goodId, quantity, dateIssued, customerId
    private final int id;
    private final Good good;
    private final int quantity;
    private final String dateIssued;
    private final Customer customer;

    public IssuedGood(int id, Good good, int quantity, String dateIssued, Customer customer) {
        this.id = id;
        this.good = good;
        this.quantity = quantity;
        this.dateIssued = dateIssued;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public Good getGood() {
        return good;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDateIssued() {
        return dateIssued;
    }

    public Customer getCustomer() {
        return customer;
    }
}
