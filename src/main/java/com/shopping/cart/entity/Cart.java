package com.shopping.cart.entity;

import com.shopping.cart.handler.AddToCartHandler;
import com.shopping.cart.handler.GenericTaxHandler;
import com.shopping.cart.handler.IAddToCartHandler;
import com.shopping.cart.handler.ITaxHandler;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Product> productList;
    private double totalPrice;

    private IAddToCartHandler addToCartHandler;
    private ITaxHandler taxHandler;
    private DecimalFormat decimalFormat;

    public Cart() {
        this.productList = new ArrayList<>();
        decimalFormat = new DecimalFormat("#.##");

        setAddToCartHandler(new AddToCartHandler());
        setTaxHandler(new GenericTaxHandler());
        setTax(0);
    }

    public void setAddToCartHandler(IAddToCartHandler addToCartHandler) {
        if(addToCartHandler instanceof IAddToCartHandler) {
            this.addToCartHandler = addToCartHandler;
            this.addToCartHandler.setProductList(productList);
        }
    }

    public void setTaxHandler(ITaxHandler taxHandler){
        if (taxHandler instanceof ITaxHandler){
            this.taxHandler = taxHandler;
        }
    }

    public void setTax(double taxRate) {
            taxHandler.setTaxRate(taxRate);
    }

    public double getCalculatedTax(){
        return getRoundOffValue(taxHandler.getTaxOnTotalPrice(getRoundOffValue(totalPrice)));
    }


    public void addProduct(Product product, int qty){
        double price = addToCartHandler.addProduct(product,qty);
        totalPrice+=price;
    }

    public long getQtyByProduct(Product product){
        return productList.stream().filter(prod->prod==product).count();
    }

    public int getCartSize(){
        return productList.size();
    }

    public double getTotalPrice(){
        return getRoundOffValue(taxHandler.getPriceAfterTax(totalPrice));
    }

    private double getRoundOffValue(double price){
        return Double.parseDouble(decimalFormat.format(price));
    }

}
