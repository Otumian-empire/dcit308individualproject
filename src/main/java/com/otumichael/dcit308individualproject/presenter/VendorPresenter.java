package com.otumichael.dcit308individualproject.presenter;

import com.otumichael.dcit308individualproject.mapper.Vendor;

public class VendorPresenter {
    private final int id;
    private final String name;
    private final String email;

    public VendorPresenter(Vendor vendor) {
        this.id = vendor.getId();
        this.name = vendor.getName();
        this.email = vendor.getEmail();
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
