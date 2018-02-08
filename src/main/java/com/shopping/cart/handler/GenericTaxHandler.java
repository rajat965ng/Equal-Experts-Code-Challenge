package com.shopping.cart.handler;

import java.text.DecimalFormat;

public class GenericTaxHandler implements ITaxHandler{

    private double taxRate;
    private DecimalFormat decimalFormat;

    @Override
    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    @Override
    public double getTaxOnTotalPrice(double totalPrice) {
        decimalFormat = new DecimalFormat("#.#");
        return Double.parseDouble(decimalFormat.format((totalPrice*taxRate)/100));
    }

    @Override
    public double getPriceAfterTax(double totalPrice) {
        decimalFormat = new DecimalFormat("#.##");
        return Double.parseDouble(decimalFormat.format(totalPrice+getTaxOnTotalPrice(totalPrice)));
    }
}
