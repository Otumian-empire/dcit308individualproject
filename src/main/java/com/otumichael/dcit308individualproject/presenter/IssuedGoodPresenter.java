package com.otumichael.dcit308individualproject.presenter;

import com.otumichael.dcit308individualproject.mapper.IssuedGood;

public class IssuedGoodPresenter {
    //    id, goodId, quantity, dateIssued, customerId
    private final int id;
    private final String goodName;
    private final int quantity;
    private final String dateIssued;
    private final String customerName;

    public IssuedGoodPresenter(IssuedGood issuedGood) {
        this.id = issuedGood.getId();
        this.goodName = issuedGood.getGood().getName();
        this.quantity = issuedGood.getQuantity();
        this.dateIssued = issuedGood.getDateIssued();
        this.customerName = issuedGood.getCustomer().getName();
    }

    public int getId() {
        return id;
    }

    public String getGoodId() {
        return goodName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDateIssued() {
        return dateIssued;
    }

    public String getCustomerName() {
        return customerName;
    }
}
