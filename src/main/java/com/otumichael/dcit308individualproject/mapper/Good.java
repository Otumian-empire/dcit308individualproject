package com.otumichael.dcit308individualproject.mapper;

public class Good {
    private final int id;
    private final String name;
    private final int price;
    private final int quantity;
    private final Category category;
    private final Vendor vendor;
    private final String description;

    public Good(
            int id,
            String name,
            int price,
            int quantity,
            Category category,
            Vendor vendor,
            String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.vendor = vendor;
        this.description = description;
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

    public Category getCategory() {
        return category;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
