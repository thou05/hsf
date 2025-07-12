package com.thou.coffee.entity;

//tuong lai la @Entity de xuong table, bua nay lam nhap trong ram new hardcode data thay vi lay tu table
public class Product {
    private String id;
    //neu key tu tang thi phai dung Long (wrapper class - so nhung luu nhu object), ko dung primitive long
    private String name;
    private double price;

    //boilerplate code: ctor, get/set, toString

    public Product() {
    }

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
