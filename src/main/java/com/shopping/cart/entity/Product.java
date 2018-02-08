package com.shopping.cart.entity;

public enum Product {

    DOVE("Dove Soap",39.99),
    AXE("Axe Deo",99.99);

    private String name;
    private double value;

    Product(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
