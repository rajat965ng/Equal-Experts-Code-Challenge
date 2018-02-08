package com.shopping.cart.handler;

public class GenericTaxHandler implements ITaxHandler{

    private double taxRate;

    @Override
    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    @Override
    public double getTaxOnTotalPrice(double totalPrice) {
        return (totalPrice*taxRate)/100;
    }

    @Override
    public double getPriceAfterTax(double totalPrice) {
        return totalPrice+getTaxOnTotalPrice(totalPrice);
    }
}
