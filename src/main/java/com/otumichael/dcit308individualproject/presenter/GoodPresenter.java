package com.otumichael.dcit308individualproject.presenter;

import com.otumichael.dcit308individualproject.mapper.Good;

public class GoodPresenter {
    private final int id;
    private final String name;
    private final int price;
    private final int quantity;
    private final String categoryName;
    private final String vendorName;
    private final String description;

    public GoodPresenter(Good good) {
        this.id = good.getId();
        this.name = good.getName();
        this.price = good.getPrice();
        this.quantity = good.getQuantity();
        this.categoryName = good.getCategory().getName();
        this.vendorName = good.getVendor().getName();
        this.description = good.getDescription();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getVendorName() {
        return vendorName;
    }

    public String getDescription() {
        return description;
    }
}
