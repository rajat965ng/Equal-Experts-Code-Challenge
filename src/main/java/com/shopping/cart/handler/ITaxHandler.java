package com.shopping.cart.handler;

public interface ITaxHandler {
    public double getTaxOnTotalPrice(double totalPrice);
    public double getPriceAfterTax(double totalPrice);
    public void setTaxRate(double taxRate);
}
