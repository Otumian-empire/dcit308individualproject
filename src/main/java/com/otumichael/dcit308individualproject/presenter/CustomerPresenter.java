package com.otumichael.dcit308individualproject.presenter;

import com.otumichael.dcit308individualproject.mapper.Customer;

public class CustomerPresenter {
    private int id;
    private String name;
    private String email;

    public CustomerPresenter(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.email = customer.getEmail();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
