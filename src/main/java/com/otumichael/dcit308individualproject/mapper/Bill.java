package com.otumichael.dcit308individualproject.mapper;

public class Bill {
    private final int id;
    private final  Good good;
    private final int quantity;
    private final int price;
    private final String dateBilled;
    private final Customer customer;

    //    Bill: id, goodId, quantity, price, dateBilled, customerId
    // goodId->Good, customerId->Customer
    public Bill(int id, Good good, int quantity, int price, String dateBilled, Customer customer) {
        this.id = id;
        this.good = good;
        this.quantity = quantity;
        this.price = price;
        this.dateBilled = dateBilled;
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

    public int getPrice() {
        return price;
    }

    public String getDateBilled() {
        return dateBilled;
    }

    public Customer getCustomer() {
        return customer;
    }

}
