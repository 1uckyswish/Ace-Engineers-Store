package com.pluralsight;

public class Product {

    private double price;
    private String sku;
    private String name;
    private String department;

    public Product(double price, String sku, String name, String department) {
        this.price = price;
        this.sku = sku;
        this.name = name;
        this.department = department;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return String.format("SKU: %s | Name: %s | Price: $%,.2f | Department: %s",
                sku, name, price, department);
    }
}
