package com.otumichael.dcit308individualproject;

import com.otumichael.dcit308individualproject.mapper.Bill;
import com.otumichael.dcit308individualproject.mapper.Good;
import com.otumichael.dcit308individualproject.mapper.IssuedGood;
import com.otumichael.dcit308individualproject.mapper.Vendor;
import com.otumichael.dcit308individualproject.presenter.BillPresenter;
import com.otumichael.dcit308individualproject.presenter.GoodPresenter;
import com.otumichael.dcit308individualproject.presenter.IssuedGoodPresenter;
import com.otumichael.dcit308individualproject.presenter.VendorPresenter;

import java.util.List;

public class PresenterUtil {
    public static GoodPresenter[] getPresentedGoods(int size, List<Good> items) {
        GoodPresenter[] presenterList = new GoodPresenter[size];
        for (int i = 0; i < size; i++) {
            presenterList[i] = new GoodPresenter(items.get(i));
        }
        return presenterList;
    }

    public static BillPresenter[] getPresentedBills(int size, List<Bill> items) {
        BillPresenter[] presenterList = new BillPresenter[size];
        for (int i = 0; i < size; i++) {
            presenterList[i] = new BillPresenter(items.get(i));
        }
        return presenterList;
    }

    public static IssuedGoodPresenter[] getPresentedIssuedGoods(int size, List<IssuedGood> items) {
        IssuedGoodPresenter[] presenterList = new IssuedGoodPresenter[size];
        for (int i = 0; i < size; i++) {
            presenterList[i] = new IssuedGoodPresenter(items.get(i));
        }
        return presenterList;
    }

    public static VendorPresenter[] getPresentedVendors(int size, List<Vendor> items) {
        VendorPresenter[] presenterList = new VendorPresenter[size];
        for (int i = 0; i < size; i++) {
            presenterList[i] = new VendorPresenter(items.get(i));
        }
        return presenterList;
    }
}
