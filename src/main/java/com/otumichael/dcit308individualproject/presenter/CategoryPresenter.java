package com.otumichael.dcit308individualproject.presenter;

import com.otumichael.dcit308individualproject.mapper.Category;

public class CategoryPresenter {

    private final int id;
    private final String name;

    public CategoryPresenter(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
