package com.otumichael.dcit308individualproject.presenter;

import com.otumichael.dcit308individualproject.mapper.Bill;

public class BillPresenter {
    private final int id;
    private final String goodName;
    private final int quantity;
    private final int price;
    private final String dateBilled;
    private final String customerName;

    // we pull the customer and good name and use this to present the data and not the mapper
    public BillPresenter(Bill bill) {
        this.id = bill.getId();
        this.goodName = bill.getGood().getName();
        this.quantity = bill.getQuantity();
        this.price = bill.getPrice();
        this.dateBilled = bill.getDateBilled();
        this.customerName = bill.getCustomer().getName();
    }

    public int getId() {
        return id;
    }

    public String getGoodName() {
        return goodName;
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

    public String getCustomerName() {
        return customerName;
    }

}
