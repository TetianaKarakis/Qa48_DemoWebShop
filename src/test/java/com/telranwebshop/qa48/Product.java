package com.telranwebshop.qa48;

public class Product {
    private  String category;
   private int index;

    public Product setCategory(String category) {
        this.category = category;
        return this;
    }

    public Product setIndex(int index) {
        this.index = index;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public int getIndex() {
        return index;
    }
}